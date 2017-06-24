package pt.nunosousamachado.app;

import pt.nunosousamachado.domain.*;
import java.util.Scanner;

/**
 * Created by nunomachado on 20/05/17.
 */
public class Application {

    public static void main(String[] args) throws IllegalSelectionException {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {

            try {
                printMenu();
                String input = scanner.nextLine();
                option = Integer.valueOf(input);

                if(option == 1) {
                    Game game = GameFactory.createGame();
                    System.out.println(game);

                    do {
                        Coordinate coordinate = readCoordinates(scanner);
                        play(game, coordinate);

                    } while(game.getGameStatus() == GameStatus.PLAYING);

                } else if (option == 2) {
                    System.out.println("See you next time!");
                    return;

                } else {
                    System.out.println("Invalid input. Choose 1 to Play Game or 2 to Exit!");
                    System.out.println();
                }

            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Choose 1 to Play Game or 2 to Exit!");
                System.out.println();
            }

        } while (option != 2);
    }

    private static void printMenu() {
        System.out.println("********** Welcome to MineSweeper **********");
        System.out.println("********** 1 - Play Game       *************");
        System.out.println("********** 2 - Exit Game       *************");
        System.out.println("************* Choose an Option *************");
        System.out.println(":::::>");
    }

    private static void play(Game game, Coordinate coordinate) {

        int rowX = coordinate.getRow();
        int columnY = coordinate.getColumn();

        try {
            game.play(rowX, columnY);
            GameStatus status = game.getGameStatus();
            System.out.println(game);

            if(status == GameStatus.LOST) {
                printLostMessage();

            } else if (status == GameStatus.WON) {
                printWinMessage();
            }

        } catch (IllegalSelectionException selection) {
            System.out.println(selection.getMessage());
            System.out.println();
        }
    }

    private static void printLostMessage() {
        System.out.println("GAME OVER! YOU LOST!");
        System.out.println();
    }

    private static void printWinMessage() {
        System.out.println("GAME OVER! YOU WIN!");
        System.out.println();
    }


    private static Coordinate readCoordinates(Scanner scanner) {

        int rowX = readRow(scanner);
        int columnY = readColumn(scanner);

        return new Coordinate(rowX, columnY);
    }

    private static int readRow(Scanner scanner) {

        int rowX = -1;
        boolean rowSet = false;

        do {
            System.out.println("Select a row to play:");
            String row = scanner.nextLine();

            try {
                rowX = Integer.valueOf(row);
                rowSet = true;

            } catch (NumberFormatException rowException) {
                System.out.println("Invalid input. Choose a number between 0 and 9! Play again.");
            }

        } while(!rowSet);

        return rowX;
    }

    private static int readColumn(Scanner scanner) {

        int columnY = -1;
        boolean columnSet = false;

        do {
            System.out.println("Select a column to play:");
            String column = scanner.nextLine();

            try {
                columnY = Integer.valueOf(column);
                columnSet = true;

            } catch (NumberFormatException columnException) {
                System.out.println("Invalid input. Choose a number between 0 and 9!");
            }

        } while (!columnSet);

        return columnY;
    }

    private static class Coordinate {

        private int row;
        private int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

}
