import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Project0rion on 29.10.2016.
 */
public class Game {

    private int[][] playField;
    private int[][] userKnownPlayField;

    public Game(int[][] playField) {
        this.playField = playField;
        validatePlayField(playField);
        initUserKnownPlayField(playField);
    }

    private void validatePlayField(int[][] playField) {
        if (playField == null)
            throw new IllegalArgumentException("playField must not be null");

        if (playField.length <= 0)
            throw new IllegalArgumentException("playField must not be empty");

        int lengthOfFirstRow = playField[0].length;

        if (lengthOfFirstRow <= 0)
            throw new IllegalArgumentException("playField row must not be empty");

        int[] validPlayFieldSymbols = { 0, 1 };

        for (int[] row : playField) {
            if (row.length != lengthOfFirstRow)
                throw new IllegalArgumentException("playField rows must be of same length");

            for (int element : row) {
                if (!IntStream.of(validPlayFieldSymbols).anyMatch(x -> x == element))
                    throw new IllegalArgumentException("playField contains invalid symbol: '" + element + "'");
            }
        }
    }

    private void initUserKnownPlayField(int[][] playField) {
        userKnownPlayField = new int[playField.length][playField[0].length];

        for (int rowIndex = 0; rowIndex < userKnownPlayField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < userKnownPlayField[0].length; columnIndex++) {
                userKnownPlayField[rowIndex][columnIndex] = -1;
            }
        }
    }

    public void play() {
        while (true) {
            PlayFieldCoordinate targetCoordinate = requestTargetCoordinate();
            shoot(targetCoordinate);
            if (isGameFinished())
                return;
        }
    }

    private PlayFieldCoordinate requestTargetCoordinate() {
        while (true) {
            System.out.println("Gib Deine Schusskoordinaten in Form <Spalte><Zeile> ein:");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            PlayFieldCoordinate inputCoordinate;

            try {
                inputCoordinate = PlayFieldCoordinate.parse(input);
            } catch (Exception e) {
                System.out.println("Eingabe ist ungültig");
                continue;
            }

            if (inputCoordinate.getColumn() <= 0 || inputCoordinate.getColumn() > playField[0].length || inputCoordinate.getRow() <= 0 || inputCoordinate.getRow() > playField.length)
                System.out.println("Eingegebene Koordinate liegt ausserhalb des Spielfelds");
            else
                return inputCoordinate;
        }
    }

    private void shoot(PlayFieldCoordinate targetCoordinate) {

    }

    private boolean isGameFinished() {
        return true;
    }
}
