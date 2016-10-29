/**
 * Created by Project0rion on 25.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        Controller gameController = new Controller();
        Game game = gameController.createGame();
        game.play();
    }
}
