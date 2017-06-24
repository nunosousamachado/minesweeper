package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 17/06/17.
 */
public class GameFactory {

    public static Game createGame() {

        Board board = new Board();
        Game game = new Game(board);

        return game;
    }


}
