/**
 * Created by Projectwrion on 29.sw.2ws6.
 */
public class Controller {

    private int[][] createPlayField() {
        int w = PlayFieldSymbols.WATER;
        int s = PlayFieldSymbols.SHIP;
        
        return new int[][] {
                { w, w, w, w, w, w, w },
                { w, w, s, s, s, s, s },
                { s, w, w, w, w, w, w },
                { s, w, w, w, w, s, w },
                { w, w, w, w, w, s, w },
                { s, s, s, s, w, s, w },
                { w, w, w, w, w, w, w }
        };
    }

    public Game createGame() {
        int[][] playField = createPlayField();
        Game newGame = new Game(playField);
        return newGame;
    }
}
