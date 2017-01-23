package repositories.generation;

import repositories.model.Card;
import repositories.model.CardRepository;
import repositories.model.Opponent;
import repositories.model.OpponentRepository;
import utils.CodeBuilder;

import java.util.Collection;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class OpponentRepositoryGenerator {

    protected enum ClassType {
        Class, Interface, Enum
    }

    public final Collection<String> generate(OpponentRepository repo) {
        CodeBuilder cb = new CodeBuilder();

        cb.addLine("package " + getOpponentsPackage() + ";");
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

    private String getOpponentsPackage() {
        return "com.hwr_goes_beuth.cardz.game.opponents";
    }

    private String[] getRepoImports(OpponentRepository repo) {
        return new String[]
                {
                        "com.hwr_goes_beuth.cardz.entities.enums.Faction",
                        "com.hwr_goes_beuth.cardz.game.opponents.behaviors.AggressiveOpponentBehavior",
                        "com.hwr_goes_beuth.cardz.game.opponents.behaviors.PassiveOpponentBehavior",
                        "java.util.ArrayList",
                        "java.util.List"
                };
    }

    private ClassType getClassType() {
        return ClassType.Class;
    }

    private String generateClassName(OpponentRepository repo) {
        return repo.getName();   }

    private void generateClassContent(OpponentRepository repo, CodeBuilder cb) {

        cb.addEmptyLine();

        generateConstructor(repo, cb);
        cb.addEmptyLine();
    }

    private void generateConstructor(OpponentRepository repo, CodeBuilder cb) {
        cb.addLine("public " + repo.getName() + "() {");
        cb.incrIndent();
        cb.addLine("List<Opponent> knownOpponents = new ArrayList<>();");

        for (Opponent opp : repo.get_opponents()) {

            if(opp.get_name().equals("shark") | opp.get_name().equals("raptor"))
                continue;

            String behavior = ((opp.get_behavior().equals("passive")) ? "Passive" : "Aggressive");

            cb.addLine("knownOpponents.add(new Opponent(\""+ opp.get_name() +"\", Faction." + opp.get_faction() + ", new " + behavior +"OpponentBehavior()));");
        }

        cb.decrIndent();
        cb.addLine("}");
    }
}
