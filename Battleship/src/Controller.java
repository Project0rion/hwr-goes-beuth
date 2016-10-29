/**
 * Created by Project0rion on 29.10.2016.
 */
public class Controller {

    private int[][] createPlayField() {
        return new int[][] {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0 }
        };
    }

    public Game createGame() {
        int[][] playField = createPlayField();
        Game newGame = new Game(playField);
        return newGame;
    }
}
