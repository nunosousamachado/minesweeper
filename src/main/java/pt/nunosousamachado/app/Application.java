package pt.nunosousamachado.app;

import pt.nunosousamachado.domain.IllegalSelectionException;
import pt.nunosousamachado.domain.MineBoard;
import pt.nunosousamachado.domain.SelectionBoard;
import pt.nunosousamachado.domain.Game;

/**
 * Created by nunomachado on 20/05/17.
 */
public class Application {

    public static void main(String[] args) throws IllegalSelectionException {

        MineBoard board = new MineBoard();
        SelectionBoard sBoard = new SelectionBoard();
        Game uBoard = new Game(board, sBoard);

        int j=0;
        while(j < 10 && uBoard.play(0,j)) {
            System.out.println(uBoard.toString());
            j++;
        }
        System.out.println(uBoard.toString());
    }

}
