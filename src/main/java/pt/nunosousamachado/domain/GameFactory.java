package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 17/06/17.
 */
public class GameFactory {

    public static Game createGame() {

        MineBoard mBoard = new MineBoard();
        SelectionBoard sBoard = new SelectionBoard();
        Game uGame = new Game(mBoard, sBoard);

        return uGame;
    }


}
