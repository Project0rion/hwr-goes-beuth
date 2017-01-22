package repositories.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public class Opponent {

    private String _name;
    private String _behavior;
    private String _faction;
    private List<Card> _deck;

    public Opponent() {
        _deck = new ArrayList<>();
    }

    public void addCardToDeck(Card card){
        _deck.add(card);
    }

    public void set_deck(List<Card> _deck) {
        this._deck = _deck;
    }

    public List<Card> get_deck() {
        return _deck;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_behavior() {
        return _behavior;
    }

    public void set_behavior(String _behavior) {
        this._behavior = _behavior;
    }

    public String get_faction() {
        return _faction;
    }

    public void set_faction(String _faction) {
        this._faction = _faction;
    }




}

