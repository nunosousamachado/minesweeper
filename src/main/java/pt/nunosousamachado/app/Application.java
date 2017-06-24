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

        do {
            try {
                System.out.println("********** Welcome to MineSweeper **********");
                System.out.println("********** 1 - Play Game       *************");
                System.out.println("********** 2 - Exit Game       *************");
                System.out.println("************* Choose an Option *************");
                System.out.println(":::::>");
                String input = scanner.nextLine();
                option = Integer.valueOf(input);

                if(option == 1) {

                    game = GameFactory.createGame();
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

                            game.play(rowX, columnY);
                            GameStatus status = game.getGameStatus();
                            System.out.println(game);

                            if(status == GameStatus.LOST) {

                                System.out.println("GAME OVER! YOU LOST!");
                                System.out.println();

                            } else if (status == GameStatus.WON) {

                                System.out.println("GAME OVER! YOU WIN!");
                                System.out.println();

                            }

                        } catch (IllegalSelectionException selection) {

                            System.out.println(selection.getMessage());
                            System.out.println();

                        }

                    } while(game.getGameStatus() == GameStatus.PLAYING);


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

}
