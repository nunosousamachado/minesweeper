package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 21/05/17.
 */
public class Game {

    private Board board;
    private GameStatus gameStatus;

    public Game(Board board) {
        this.board = board;
        this.gameStatus = GameStatus.PLAYING;
    }

    public GameStatus getGameStatus() {

        return this.gameStatus;
    }

    public void play (int x, int y) throws IllegalSelectionException {

        Field field =  board.getField(x, y);

        if(field.isAMine()) {
            field.setStatus(FieldStatus.OPENED);
            gameStatus = GameStatus.LOST;
            board.revealBoard();

        } else {
            field.setStatus(FieldStatus.OPENED);

            if(isGameFinished()) {

                gameStatus = GameStatus.WON;
                board.revealBoard();
            }
        }
    }

    private boolean isGameFinished() {

        return board.getTotalNumberMines() == board.getTotalNumberOfFieldsClosed();
    }

    @Override
    public String toString() {

        return board.toString();
    }
    
}
