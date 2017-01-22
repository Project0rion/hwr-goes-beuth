package repositories.model;

/**
 * Created by User on 22.01.2017.
 */
public class RepositoryModel {

    private CardRepository _cardRepo;
    private DeckRepository _deckRepo;
    private OpponentRepository _opponentRepo;

    public RepositoryModel() {

    }

    public CardRepository createCardRepository() {
        _cardRepo = new CardRepository();
        return _cardRepo;
    }

    public DeckRepository createDeckRepository() {
        _deckRepo = new DeckRepository();
        return _deckRepo;
    }

    public OpponentRepository createOpponentRepository() {
        _opponentRepo = new OpponentRepository();
        return _opponentRepo;
    }

    public CardRepository get_cardRepo() {
        return _cardRepo;
    }

    public DeckRepository get_deckRepo() {
        return _deckRepo;
    }

    public OpponentRepository get_opponentRepo() {
        return _opponentRepo;
    }
}
