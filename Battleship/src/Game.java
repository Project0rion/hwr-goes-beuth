import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Project0rion on 29.10.2016.
 */
public class Game {

    private int[][] cpuPlayField;
    private int[][] userKnownCpuPlayField;
    private int[][] userPlayField;
    private int[][] cpuKnownUserPlayField;

    private Opponent opponent;

    public Game(int[][] cpuPlayField) {
        this.cpuPlayField = cpuPlayField;
        validatePlayField(cpuPlayField);
        userKnownCpuPlayField = createUnknownPlayField(cpuPlayField);
        cpuKnownUserPlayField = createUnknownPlayField(cpuPlayField);
        opponent = new Opponent();
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

    private int[][] createUnknownPlayField(int[][] sourcePlayField) {
        int[][] unknownPlayField = new int[sourcePlayField.length][sourcePlayField[0].length];

        for (int rowIndex = 0; rowIndex < unknownPlayField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < unknownPlayField[0].length; columnIndex++) {
                unknownPlayField[rowIndex][columnIndex] = PlayFieldSymbols.UNKNOWN;
            }
        }

        return unknownPlayField;
    }

    public void play() {
        System.out.println("Willkommen zu Battleship!");
        userPlayField = requestUserPlayField();

        System.out.println();
        System.out.println("Alle Schiffe sind platziert.");
        System.out.println("Das Spiel beginnt!");
        System.out.println("Besiege Deinen Gegner mit moeglichst wenig Schuessen!");
        System.out.println();
        showReport();

        while (true) {
            PlayFieldCoordinate targetCoordinate = requestTargetCoordinate();
            shoot(targetCoordinate);

            if (isGameFinished()) {
                showReport();
                showFinalReport();
                return;
            }

            PlayFieldCoordinate cpuTargetCoordinate = opponent.shoot(cpuKnownUserPlayField);
            cpuKnownUserPlayField[cpuTargetCoordinate.getRow()][cpuTargetCoordinate.getColumn()] = userPlayField[cpuTargetCoordinate.getRow()][cpuTargetCoordinate.getColumn()];

            boolean cpuShotShip = userPlayField[cpuTargetCoordinate.getRow()][cpuTargetCoordinate.getColumn()] == PlayFieldSymbols.SHIP;
            System.out.println("Der Computer schiesst auf " + cpuTargetCoordinate + "... " + (cpuShotShip ? "Treffer!" : "Daneben!"));

            showReport();

            if (isGameFinished()) {
                showFinalReport();
                return;
            }
        }
    }

    private int[][] requestUserPlayField() {
        System.out.println("Platziere deine Schiffe!");
        System.out.println();

        int[] shipsToPlace = { 5, 4, 3, 2 };
        int[][] newUserPlayField = new int[cpuPlayField.length][cpuPlayField[0].length];

        for (int i = 0; i < newUserPlayField.length; i++) {
            for (int j = 0; j < newUserPlayField[0].length; j++) {
                newUserPlayField[i][j] = PlayFieldSymbols.WATER;
            }
        }

        while (shipsToPlace.length > 0) {
            System.out.println("Dein aktuelles Spielfield:");
            showPlayField(newUserPlayField);

            System.out.println();
            System.out.println("Platziere jetzt einen " + shipsToPlace[0] + "er!");
            PlayFieldCoordinate inputCoordinate;
            boolean placedShipSuccessfully = false;

            while (!placedShipSuccessfully) {
                while (true) {
                    System.out.println("Gib die Koordinate der oberen linken Ecke in Form <Spalte><Zeile> ein:");
                    inputCoordinate = requestCoordinate(newUserPlayField);

                    if (newUserPlayField[inputCoordinate.getRow()][inputCoordinate.getColumn()] == PlayFieldSymbols.SHIP)
                        System.out.println("An dieser Koordinate ist bereits ein anderes Schiff platziert!");
                    else
                        break;
                }

                boolean placeShipHorizontally;

                while (true) {
                    System.out.println("Soll das Schiff horizontal oder vertikal platziert werden? [h | v]");
                    Scanner sc = new Scanner(System.in);
                    String input = sc.nextLine();

                    if (!(input.equals("h") || input.equals("v")))
                        System.out.println("Eingabe ist ungültig");
                    else {
                        placeShipHorizontally = input.equals("h");
                        break;
                    }
                }

                placedShipSuccessfully = tryPlaceShip(newUserPlayField, inputCoordinate, shipsToPlace[0], placeShipHorizontally);
            }

            if (placedShipSuccessfully)
                shipsToPlace = Arrays.copyOfRange(shipsToPlace, 1, shipsToPlace.length);
        }

        return newUserPlayField;
    }

    private PlayFieldCoordinate requestTargetCoordinate() {
        while (true) {
            System.out.println("Gib Deine Schusskoordinaten in Form <Spalte><Zeile> ein:");
            PlayFieldCoordinate inputCoordinate = requestCoordinate(cpuPlayField);

            if (userKnownCpuPlayField[inputCoordinate.getRow()][inputCoordinate.getColumn()] != PlayFieldSymbols.UNKNOWN)
                System.out.println("Dieses Feld wurde bereits beschossen");
            else
                return inputCoordinate;
        }
    }

    private PlayFieldCoordinate requestCoordinate(int[][] playField) {
        while (true) {
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
            else
                return inputCoordinate;
        }
    }

    private boolean tryPlaceShip(int[][] playField, PlayFieldCoordinate upperLeftCoordinate, int length, boolean placeHorizontally) {
        PlayFieldCoordinate[] shipCoordinates = new PlayFieldCoordinate[length];

        for (int i = 0; i < shipCoordinates.length; i++) {
            shipCoordinates[i] = new PlayFieldCoordinate(upperLeftCoordinate.getColumn() + (placeHorizontally ? i : 0), upperLeftCoordinate.getRow() + (!placeHorizontally ? i : 0));
        }

        for (PlayFieldCoordinate shipCoordinate : shipCoordinates) {
            if (shipCoordinate.getRow() > playField.length - 1 || shipCoordinate.getColumn() > playField[0].length - 1) {
                System.out.println("Schiff kann nicht platziert werden, weil es über die Spielfeldgrenzen hinaus ragt");
                return false;
            }
            else if (playField[shipCoordinate.getRow()][shipCoordinate.getColumn()] == PlayFieldSymbols.SHIP) {
                System.out.println("Schiff kann nicht platziert werden, weil es ein anders Schiff schneidet");
                return false;
            }
            else {
                ArrayList<PlayFieldCoordinate> neighborCoordinates = new ArrayList<>();

                for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                    for (int colOffset = -1; colOffset <= 1; colOffset++) {

                        if (rowOffset == 0 && colOffset == 0)
                            continue;
                        if (shipCoordinate.getRow() + rowOffset < 0 || shipCoordinate.getColumn() + colOffset < 0)
                            continue;
                        if (shipCoordinate.getRow() + rowOffset > playField.length - 1 || shipCoordinate.getColumn() + colOffset > playField[0].length - 1)
                            continue;

                        neighborCoordinates.add(new PlayFieldCoordinate(shipCoordinate.getColumn() + colOffset, shipCoordinate.getRow() + rowOffset));
                    }
                }

                for (PlayFieldCoordinate neighborCoordinate : neighborCoordinates) {
                    boolean neighborCoordinateIsSameShip = false;

                    for (PlayFieldCoordinate currentShipCoordinate : shipCoordinates) {
                        if (neighborCoordinate.equals(currentShipCoordinate))
                            neighborCoordinateIsSameShip = true;
                    }

                    if (!neighborCoordinateIsSameShip && playField[neighborCoordinate.getRow()][neighborCoordinate.getColumn()] == PlayFieldSymbols.SHIP) {
                        System.out.println("Schiff kann nicht platziert werden, weil es ein anderes Schiff berührt");
                        return false;
                    }
                }
            }
        }

        for (PlayFieldCoordinate shipCoordinate : shipCoordinates) {
            playField[shipCoordinate.getRow()][shipCoordinate.getColumn()] = PlayFieldSymbols.SHIP;
        }

        return true;
    }

    private void shoot(PlayFieldCoordinate targetCoordinate) {
        int elementAtCoordinate = cpuPlayField[targetCoordinate.getRow()][targetCoordinate.getColumn()];
        userKnownCpuPlayField[targetCoordinate.getRow()][targetCoordinate.getColumn()] = elementAtCoordinate;

        if (elementAtCoordinate == PlayFieldSymbols.SHIP) {
            System.out.println("Treffer");
        } else if (elementAtCoordinate == PlayFieldSymbols.WATER) {
            System.out.println("Daneben");
        }
    }

    private boolean isGameFinished() {
         return hasUserWon() || hasCpuWon();
    }

    private boolean hasUserWon() {
        for (int rowIndex = 0; rowIndex < cpuPlayField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < cpuPlayField[0].length; columnIndex++) {
                if (cpuPlayField[rowIndex][columnIndex] == PlayFieldSymbols.SHIP && userKnownCpuPlayField[rowIndex][columnIndex] != PlayFieldSymbols.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCpuWon() {
        for (int rowIndex = 0; rowIndex < userPlayField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < userPlayField[0].length; columnIndex++) {
                if (userPlayField[rowIndex][columnIndex] == PlayFieldSymbols.SHIP && cpuKnownUserPlayField[rowIndex][columnIndex] != PlayFieldSymbols.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }

    private void showPlayField(int[][] playField) {
        System.out.println();

        String columnHeader = "  ";
        for (int i = 0; i < playField[0].length; i++) {
            columnHeader += (char)(i + 97) + " ";
        }

        System.out.println(columnHeader.toUpperCase());

        for (int i = 0; i < playField.length; i++) {
            String row = "";
            for (int j = 0; j < playField[i].length; j++) {
                row += getOutputSymbol(playField[i][j]) + " ";
            }

            System.out.println(i+1 + " " + row);
        }

        System.out.println();
    }

    private void showReport() {
        String bigSpace = "      ";
        String smallSpace = "   ";

        System.out.println();
        System.out.println("Gegnerisches Spielfeld" + bigSpace + smallSpace + "Eigenes Spielfeld");
        System.out.println();

        String columnHeader = "  ";
        for (int i = 0; i < userKnownCpuPlayField[0].length; i++) {
            columnHeader += (char)(i + 97) + " ";
        }

        columnHeader += bigSpace + columnHeader + smallSpace + columnHeader;

        System.out.println(columnHeader.toUpperCase());

        for (int i = 0; i < userKnownCpuPlayField.length; i++) {
            String row = (i + 1) + " ";
            for (int j = 0; j < userKnownCpuPlayField[i].length; j++) {
                row += getOutputSymbol(userKnownCpuPlayField[i][j]) + " ";
            }

            row += bigSpace + (i + 1) + " ";
            for (int j = 0; j < cpuKnownUserPlayField[i].length; j++) {
                row += getOutputSymbol(cpuKnownUserPlayField[i][j]) + " ";
            }

            row += smallSpace + (i + 1) + " ";
            for (int j = 0; j < userPlayField[i].length; j++) {
                row += getOutputSymbol(userPlayField[i][j]) + " ";
            }

            System.out.println(row);
        }

        System.out.println();
    }

    private void showFinalReport() {

        if (hasUserWon()) {
            System.out.println("Du hast das Spiel nach Abgabe von " + countShotsFired(userKnownCpuPlayField) + " Schuessen gewonnen");
        }
        else if (hasCpuWon()) {
            System.out.println("Der Computer hat das Spiel nach Abgabe von " + countShotsFired(cpuKnownUserPlayField) + " Schuessen gewonnen");
        }
    }

    private int countShotsFired(int[][] playField) {
        int shotsFired = 0;

        for (int rowIndex = 0; rowIndex < playField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < playField[0].length; columnIndex++) {
                if (playField[rowIndex][columnIndex] != PlayFieldSymbols.UNKNOWN) {
                    shotsFired ++;
                }
            }
        }

        return shotsFired;
    }

    private Character getOutputSymbol(int playFieldSymbol) {
        HashMap<Integer, Character> outputSymbols = new HashMap<>();
        outputSymbols.put(PlayFieldSymbols.UNKNOWN, '?');
        outputSymbols.put(PlayFieldSymbols.SHIP, 'X');
        outputSymbols.put(PlayFieldSymbols.WATER, '~');

        return outputSymbols.get(playFieldSymbol);
    }
}
