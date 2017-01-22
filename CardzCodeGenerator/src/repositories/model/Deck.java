package repositories.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public class Deck {

    private Opponent _owner;
    private List<Card> _cards;

    public Deck() {
        _cards = new ArrayList<>();
    }

    public Opponent get_owner() {
        return _owner;
    }

    public void set_owner(Opponent _owner) {
        this._owner = _owner;
    }

    public void addCardToDeck(Card card){
        _cards.add(card);
    }

    public List<Card> get_deck() {
        return _cards;
    }


}
