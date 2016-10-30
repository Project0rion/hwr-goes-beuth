import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Project0rion on 29.10.2016.
 */
public class Game {

    private static final int PLAY_FIELD_SYMBOL_UNKNOWN = -1;

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

        int[] validPlayFieldSymbols = { PlayFieldSymbols.WATER, PlayFieldSymbols.SHIP };

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
                userKnownPlayField[rowIndex][columnIndex] = PLAY_FIELD_SYMBOL_UNKNOWN;
            }
        }
    }

    public void play() {
        System.out.println("Das Spiel beginnt!");
        System.out.println("Besiege Deinen Gegner mit moeglichst wenig Schuessen!");
        System.out.println();
        showReport();

        while (true) {
            PlayFieldCoordinate targetCoordinate = requestTargetCoordinate();
            shoot(targetCoordinate);
            showReport();

            if (isGameFinished()) {
                showFinalReport();
                return;
            }
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

            if (inputCoordinate.getColumn() < 0 || inputCoordinate.getColumn() > playField[0].length - 1 || inputCoordinate.getRow() < 0 || inputCoordinate.getRow() > playField.length - 1)
                System.out.println("Eingegebene Koordinate liegt ausserhalb des Spielfelds");
            else if (userKnownPlayField[inputCoordinate.getRow()][inputCoordinate.getColumn()] != PLAY_FIELD_SYMBOL_UNKNOWN)
                System.out.println("Dieses Feld wurde bereits beschossen");
            else
                return inputCoordinate;
        }
    }

    private void shoot(PlayFieldCoordinate targetCoordinate) {
        int elementAtCoordinate = playField[targetCoordinate.getRow()][targetCoordinate.getColumn()];
        userKnownPlayField[targetCoordinate.getRow()][targetCoordinate.getColumn()] = elementAtCoordinate;

        if (elementAtCoordinate == PlayFieldSymbols.SHIP) {
            System.out.println("Treffer");
        } else if (elementAtCoordinate == PlayFieldSymbols.WATER) {
            System.out.println("Daneben");
        }
    }

    private boolean isGameFinished() {
        for (int rowIndex = 0; rowIndex < playField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < playField[0].length; columnIndex++) {
                if (playField[rowIndex][columnIndex] == PlayFieldSymbols.SHIP && userKnownPlayField[rowIndex][columnIndex] != PlayFieldSymbols.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }

    private void showReport() {
        System.out.println("Bekanntes Spielfeld:");
        System.out.println();

        String columnHeader = "  ";
        for (int i = 0; i < userKnownPlayField[0].length; i++) {
            columnHeader += (char)(i + 97) + " ";
        }

        System.out.println(columnHeader.toUpperCase());

        HashMap<Integer, Character> outputSymbols = new HashMap<>();
        outputSymbols.put(PLAY_FIELD_SYMBOL_UNKNOWN, '?');
        outputSymbols.put(PlayFieldSymbols.SHIP, 'X');
        outputSymbols.put(PlayFieldSymbols.WATER, '~');

        for (int i = 0; i < userKnownPlayField.length; i++) {
            String row = "";
            for (int j = 0; j < userKnownPlayField[i].length; j++) {
                row += outputSymbols.get(userKnownPlayField[i][j]) + " ";
            }

            System.out.println(i+1 + " " + row);
        }

        System.out.println();
    }

    private void showFinalReport() {
        int shotsFired = 0;
        for (int rowIndex = 0; rowIndex < userKnownPlayField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < userKnownPlayField[0].length; columnIndex++) {
                if (userKnownPlayField[rowIndex][columnIndex] != PLAY_FIELD_SYMBOL_UNKNOWN) {
                    shotsFired ++;
                }
            }
        }

        System.out.println("Du hast das Spiel nach Abgabe von " + shotsFired + " Schuessen gewonnen");
    }
}
