package repositories;

import repositories.antlr.RepositoryBaseListener;
import repositories.antlr.RepositoryParser;
import repositories.model.*;

public class RepositoryBuilder extends RepositoryBaseListener {

    private RepositoryModel repoModel;
    private CardRepository cardRepo;
    private DeckRepository deckRepo;
    private OpponentRepository opponentRepo;
    private Card currentCard;
    private Deck currentDeck;
    private Opponent currentOpponent;

    @Override
    public void enterFile(RepositoryParser.FileContext ctx) {
        System.out.println("> started parsing");

        repoModel = new RepositoryModel();
        cardRepo = repoModel.createCardRepository();
        deckRepo = repoModel.createDeckRepository();
        opponentRepo = repoModel.createOpponentRepository();


    }

    @Override
    public void enterCard(RepositoryParser.CardContext ctx) {
        String cardName = ctx.name().getText();

        Card newCard = new Card();
        newCard.set_name(cardName);

        currentCard = newCard;
    }

    @Override
    public void exitCard(RepositoryParser.CardContext ctx) {
        cardRepo.addCard(currentCard);
        currentCard = null;
    }

    @Override
    public void enterOpponent(RepositoryParser.OpponentContext ctx) {
        String opponentName = ctx.name().getText();

        Opponent newOpponent = new Opponent();
        newOpponent.set_name(opponentName);

        currentOpponent = newOpponent;
    }

    @Override
    public void exitOpponent(RepositoryParser.OpponentContext ctx) {
        opponentRepo.addOpponent(currentOpponent);
        currentOpponent = null;
    }

    @Override
    public void enterDeck(RepositoryParser.DeckContext ctx) {
        if(currentOpponent == null)
            throw new NullPointerException("Opponent shouldnt be null when deck is read");

        Deck newDeck = new Deck();

        newDeck.set_owner(currentOpponent);
        currentDeck = newDeck;
    }

    @Override
    public void exitDeck(RepositoryParser.DeckContext ctx) {
        deckRepo.addDeck(currentDeck);
        currentDeck = null;
    }

    @Override
    public void enterDeckCard(RepositoryParser.DeckCardContext ctx) {
        if(currentOpponent == null)
            throw new NullPointerException("Opponent shouldnt be null when deckCard is read");

        if(currentDeck == null)
            throw new NullPointerException("Deck shouldnt be null when deckCard is read");
        Card newDeckCard = new Card();
        newDeckCard.set_name(ctx.name().getText());
        currentDeck.addCardToDeck(newDeckCard);
        currentOpponent.addCardToDeck(newDeckCard);
    }

    @Override
    public void enterDataFaction(RepositoryParser.DataFactionContext ctx) {
        if(currentCard != null)
            currentCard.set_faction(ctx.faction().getText());
        else if(currentOpponent !=  null)
            currentOpponent.set_faction(ctx.faction().getText());
        else
            throw new NullPointerException("currentCard and opponent are null when a data is read");
    }

    @Override
    public void enterDataDamage(RepositoryParser.DataDamageContext ctx) {
        if(currentCard == null)
            throw new NullPointerException("currentCard cannot be null when a data is read");

        currentCard.set_damage(Integer.valueOf(ctx.value().getText()));
    }

    @Override
    public void enterDataCost(RepositoryParser.DataCostContext ctx) {
        if(currentCard == null)
            throw new NullPointerException("currentCard cannot be null when a data is read");

        currentCard.set_cost(Integer.valueOf(ctx.value().getText()));
    }

    @Override
    public void enterDataHealth(RepositoryParser.DataHealthContext ctx) {
        if(currentCard == null)
            throw new NullPointerException("currentCard cannot be null when a data is read");

        currentCard.set_health(Integer.valueOf(ctx.value().getText()));
    }

    @Override
    public void enterOpponentData(RepositoryParser.OpponentDataContext ctx) {
        if(currentOpponent == null)
            throw new NullPointerException("Opponent shouldnt be null when OpponentData is read");
        currentOpponent.set_behavior(ctx.dataBehavior().BEHAVIOR().getText());
        currentOpponent.set_faction(ctx.dataFaction().faction().getText());
    }

    @Override
    public void exitFile(RepositoryParser.FileContext ctx) {
        cardRepo = null;
        opponentRepo = null;
        deckRepo = null;
        System.out.println("> finished parsing");
    }

    public RepositoryModel getRepoModel() { return repoModel; }

    public CardRepository getCardRepo() {
        return cardRepo;
    }

    public OpponentRepository getOpponentRepo() {
        return opponentRepo;
    }

    public DeckRepository getDeckRepo() {
        return deckRepo;
    }
}
