package repositories.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public class CardRepository {
    private List<Card> _cards;

    public CardRepository() {
        _cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        _cards.add(card);
    }

    public String getName() {
        return "CardRepository";
    }

    public List<Card> get_cards() {
        return _cards;
    }
}
