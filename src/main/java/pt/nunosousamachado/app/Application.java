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
        int rowX;
        int columnY;
        String row;
        String column;
        Game game;
        boolean playResult = true;

        do {
            try {
                System.out.println("********** Welcome to MineSweeper **********");
                System.out.println("********** 1 - Play Game");
                System.out.println("********** 2 - Exit Game");
                System.out.println("********** ********** ********** **********");
                System.out.println("Choose an option:");
                String input = scanner.nextLine();
                option = Integer.valueOf(input);

                if(option == 1) {

                    game = generateGame();
                    System.out.println(game);

                    do {
                        System.out.println("Select a row to play:");
                        row = scanner.nextLine();
                        try {
                            rowX = Integer.valueOf(row);

                        } catch (NumberFormatException rowException) {

                            System.out.println("Invalid input. Choose a number between 0 and 9! Play again.");
                            continue;
                        }

                        System.out.println("Select a column to play:");
                        column = scanner.nextLine();

                        try{
                            columnY = Integer.valueOf(column);

                        } catch (NumberFormatException columnException) {

                            System.out.println("Invalid input. Choose a number between 0 and 9!");
                            continue;
                        }

                        try {

                            playResult = game.play(rowX, columnY);
                            System.out.println(game);

                        } catch (IllegalSelectionException selection) {

                            System.out.println(selection.getMessage());
                            System.out.println();

                        } catch (IllegalDuplicateSelectionException duplicateSelection) {

                            System.out.println(duplicateSelection.getMessage());
                            System.out.println();
                        }

                    } while(playResult);

                    System.out.println("BUUUMMMMM!!! GAME OVER!!!");
                    System.out.println();

                } else if (option == 2) {
                    System.out.println("See you next time!");
                    return;
                } else {
                    System.out.println("Invalid input. Choose 1 to Play Game ou 2 to Exit!");
                    System.out.println();
                }

            } catch (NumberFormatException exception) {

                System.out.println("Invalid input. Choose 1 to Play Game ou 2 to Exit!");
                System.out.println();

            }

        } while (option != 2);

    }


    public static Game generateGame() {

        MineBoard board = new MineBoard();
        SelectionBoard sBoard = new SelectionBoard();
        Game uBoard = new Game(board, sBoard);

        return uBoard;
    }


}
