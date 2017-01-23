package repositories.generation;

import repositories.model.*;
import utils.CodeBuilder;

import java.util.Collection;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class DeckRepositoryGenerator {

    protected enum ClassType {
        Class, Interface, Enum
    }

    public final Collection<String> generate(DeckRepository deckRepo, OpponentRepository opponentRepo) {
        CodeBuilder cb = new CodeBuilder();

        cb.addLine("package " + getEntityPackage() + ";");
        cb.addEmptyLine();

        for (String importStatement : getRepoImports(deckRepo)) {
            cb.addLine("import " + importStatement + ";");
        }

        cb.addEmptyLine();

        String classDeclaration = "public " + getClassType().toString().toLowerCase() + " " + generateClassName(deckRepo) + " ";
        cb.addLine(classDeclaration + "{");

        cb.addEmptyLine();
        cb.incrIndent();

        generateClassContent(deckRepo, opponentRepo, cb);

        cb.decrIndent();
        cb.addLine("}");

        return cb.getCodeLines();
    }

    private String getEntityPackage() {
        return "com.hwr_goes_beuth.cardz.entities";
    }

    private String[] getRepoImports(DeckRepository repo) {
        return new String[]
                {
                        "com.hwr_goes_beuth.cardz.core.dataAccess.DAOFactory",
                        "com.hwr_goes_beuth.cardz.entities.Card",
                        "com.hwr_goes_beuth.cardz.entities.Deck",
                        "com.hwr_goes_beuth.cardz.entities.Player",
                        "com.hwr_goes_beuth.cardz.entities.User",
                        "java.util.NoSuchElementException"
                };
    }

    private ClassType getClassType() {
        return ClassType.Class;
    }

    private String generateClassName(DeckRepository repo) { return repo.getName(); }

    private void generateClassContent(DeckRepository deckRepo, OpponentRepository opponentRepo, CodeBuilder cb) {

        cb.addLine("private DAOFactory daoFactory;");
        cb.addLine("private CardRepository cardRepository;");

        cb.addEmptyLine();

        generateConstructor(deckRepo, cb);
        cb.addEmptyLine();

        generateOpponentDeckMethods(opponentRepo, cb);

        cb.addEmptyLine();

        //generate addCardToDeck-Methode
        cb.addLine("private void addCardToDeck(Deck playerDeck, String cardName) {");
        cb.incrIndent();
        cb.addLine("Card newCard = daoFactory.getDeckDAO().createCardInDeck(playerDeck);");
        cb.addLine("Card repoCard = cardRepository.getCardByName(cardName, playerDeck.getFaction());");

        cb.addLine("if (repoCard == null)");
        cb.incrIndent();
        cb.addLine("throw new NoSuchElementException(\"there is no known card called \" + cardName);");
        cb.decrIndent();
        cb.addLine("newCard.setName(repoCard.getName());");
        cb.addLine("newCard.setFaction(repoCard.getFaction());");
        cb.addLine("newCard.setDamage(repoCard.getDamage());");
        cb.addLine("newCard.setHealth(repoCard.getHealth());");
        cb.addLine("newCard.setCost(repoCard.getCost());");
        cb.addEmptyLine();
        cb.addLine("daoFactory.getCardDAO().updateCard(newCard);");
        cb.decrIndent();
        cb.addLine("}");

    }

    private void generateOpponentDeckMethods(OpponentRepository oppRepo, CodeBuilder cb)  {

        //generate createOpponentDeck
        cb.addLine("public void createOpponentDeck(Player opponentPlayer) {");
        cb.incrIndent();
        boolean firstDone = false;

        for (Opponent opp : oppRepo.get_opponents()) {


            String oppName = opp.get_name();
            if(oppName.equals("shark") | oppName.equals("raptor"))
                continue;
            if(!firstDone){
                cb.addLine("if (opponentPlayer.getName() == \"" + oppName + "\")");
                cb.incrIndent();
                cb.addLine("create" + oppName + "Deck(opponentPlayer);");
                cb.decrIndent();
                firstDone = true;
            } else {
                cb.addLine("else if (opponentPlayer.getName() == \"" + oppName + "\")");
                cb.incrIndent();
                cb.addLine("create" + oppName + "Deck(opponentPlayer);");
                cb.decrIndent();
            }
        }

        cb.addLine("else");
        cb.incrIndent();
        cb.addLine("throw new UnsupportedOperationException(\"there is no deck registered for opponent called\" + opponentPlayer.getName());");
        cb.decrIndent();
        cb.decrIndent();
        cb.addLine("}");
        cb.addEmptyLine();

        //generate createDeck-Methode for each Opponent
        for (Opponent opp : oppRepo.get_opponents()) {

            String oppName = opp.get_name();

            if(oppName.equals("shark")) {
                cb.addLine("private void createInitialSharkDeck (Player opponentPlayer){");
                cb.incrIndent();
                cb.addLine("Deck sharkDeck = daoFactory.getUserDAO().getSharkDeck(user);");
                for(Card card : opp.get_deck()) {
                    cb.addLine("addCardToDeck(sharkDeck,\""+ card.get_name() + "\");");
                }
                cb.decrIndent();
                cb.addLine("}");
                cb.addEmptyLine();
            }
            else if(oppName.equals("raptor")) {
                cb.addLine("private void createInitialRaptorDeck (Player opponentPlayer){");
                cb.incrIndent();
                cb.addLine("Deck raptorDeck = daoFactory.getUserDAO().getRaptorDeck(user);");
                for(Card card : opp.get_deck()) {
                    cb.addLine("addCardToDeck(raptorDeck,\""+ card.get_name() + "\");");
                }
                cb.decrIndent();
                cb.addLine("}");
                cb.addEmptyLine();
            }
            else {
                cb.addLine("private void create" + oppName + "Deck (Player opponentPlayer){");
                cb.incrIndent();
                cb.addLine("Deck opponentDeck = daoFactory.getDeckDAO().getDeck(opponentPlayer.getDeckId());");
                for(Card card : opp.get_deck()) {
                    cb.addLine("addCardToDeck(opponentDeck,\""+ card.get_name() + "\");");
                }
                cb.decrIndent();
                cb.addLine("}");
                cb.addEmptyLine();
            }
        }
    }

    private void generateConstructor(DeckRepository repo, CodeBuilder cb) {
        cb.addLine("public " + repo.getName() + "(DAOFactory daoFactory, CardRepository cardRepository) {");
        cb.incrIndent();
        cb.addLine("this.daoFactory = daoFactory;");
        cb.addLine("this.cardRepository = cardRepository;");
        cb.decrIndent();
        cb.addLine("}");
    }
}
