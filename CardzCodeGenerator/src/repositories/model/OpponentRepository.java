package repositories.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.01.2017.
 */
public class OpponentRepository {

    private List<Opponent> _opponents;

    public OpponentRepository() {
        _opponents = new ArrayList<>();
    }

    public void addOpponent(Opponent opp) {
        _opponents.add(opp);
    }

    public List<Opponent> get_opponents() {
        return _opponents;
    }

    public String getName() {
        return "OpponentRepository";
    }
}
