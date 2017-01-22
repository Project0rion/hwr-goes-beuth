package repositories.generation;

import entities.generation.GeneratorBase;
import entities.model.Entity;
import entities.model.Property;
import repositories.model.Card;
import repositories.model.CardRepository;
import utils.CodeBuilder;
import utils.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class CardRepositoryGenerator{

    protected enum ClassType {
        Class, Interface, Enum
    }

    public final Collection<String> generate(CardRepository repo) {
        CodeBuilder cb = new CodeBuilder();

        cb.addLine("package " + getEntityPackage() + ";");
        cb.addEmptyLine();

        for (String importStatement : getRepoImports(repo)) {
            cb.addLine("import " + importStatement + ";");
        }

        cb.addEmptyLine();

        String classDeclaration = "public " + getClassType().toString().toLowerCase() + " " + generateClassName(repo) + " ";
        cb.addLine(classDeclaration + "{");

        cb.addEmptyLine();
        cb.incrIndent();

        generateClassContent(repo, cb);

        cb.decrIndent();
        cb.addLine("}");

        return cb.getCodeLines();
    }

    private String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.entities";
    }

    private String[] getRepoImports(CardRepository repo) {
        return new String[]
                {
                        "java.util.List",
                        "java.util.ArrayList",
                        "com.hwr_goes_beuth.cardz.entities.enums.Faction",
                        "com.hwr_goes_beuth.cardz.entities.Card"
                };
    }

    private ClassType getClassType() {
        return ClassType.Class;
    }

    private String generateClassName(CardRepository repo) {
        return repo.getName();   }

    private void generateClassContent(CardRepository repo, CodeBuilder cb) {

        cb.addLine("private List<Card> knownCards;");

        cb.addEmptyLine();

        generateConstructor(repo, cb);
        cb.addEmptyLine();

        cb.addLine("public List<Card> getKnownCards() { return knownCards; }");

        cb.addEmptyLine();

        cb.addLine("private Card createCard(Faction faction, String name, int damage, int health, int cost) {");
        cb.incrIndent();
        cb.addLine("Card newCard = new Card();");
        cb.addLine("newCard.setName(name);");
        cb.addLine("newCard.setFaction(faction);");
        cb.addLine("newCard.setDamage(damage);");
        cb.addLine("newCard.setHealth(health);");
        cb.addLine("newCard.setCost(cost);");
        cb.addEmptyLine();
        cb.addLine("return newCard;");
        cb.decrIndent();
        cb.addLine("}");

        cb.addEmptyLine();

        cb.addLine("public Card getCardByName(String cardName, Faction faction) {");
        cb.incrIndent();
        cb.addLine("for (Card card : knownCards) {");
        cb.incrIndent();
        cb.addLine("if (card.getFaction() == faction && card.getName() == cardName)");
        cb.incrIndent();
        cb.addLine("return card;");
        cb.decrIndent();
        cb.addLine("}");
        cb.decrIndent();
        cb.addLine("return null;");
        cb.decrIndent();
        cb.addLine("}");

    }

    private void generateConstructor(CardRepository repo, CodeBuilder cb) {
        cb.addLine("public " + repo.getName() + "() {");
        cb.incrIndent();
        cb.addLine("knownCards = new ArrayList<>();");
        for (Card card : repo.get_cards()) {
            cb.addLine("knownCards.add(createCard(Faction." + card.get_faction() + ", '"  + card.get_name() + "', "  + card.get_damage() + ", "  + card.get_health() + ", "  + card.get_cost() +");");
        }

        cb.decrIndent();
        cb.addLine("}");
    }
}
