package repositories.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public class DeckRepository {

    private List<Deck> _decks;

    public DeckRepository() {
        _decks = new ArrayList<>();
    }

    public void addDeck(Deck deck) {
        _decks.add(deck);
    }

    public String getName() {
        return "DeckRepository";
    }

    public List<Deck> get_decks() {
        return _decks;
    }

}
