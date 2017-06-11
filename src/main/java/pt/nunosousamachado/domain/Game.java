package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 21/05/17.
 */
public class Game {

    private MineBoard mineBoard;
    private SelectionBoard selectionBoard;
    private static final int DIM = 10;

    public Game(MineBoard mineBoard, SelectionBoard selectionBoard) {
        this.mineBoard = mineBoard;
        this.selectionBoard = selectionBoard;
    }

    public boolean play (int x, int y) throws IllegalSelectionException, IllegalDuplicateSelectionException {

        selectionBoard.registerSelection(x, y);

        if(mineBoard.isAMine(x, y)) {

            return false;

        } else {

            return true;
        }
    }

    public String revealBoard() {

        StringBuilder reveal = new StringBuilder();

        for(int i=0; i<DIM; i++) {
            for (int j=0; j<DIM; j++) {

                reveal.append("\t");
                if(mineBoard.isAMine(i,j)) {

                    reveal.append('*');
                } else {

                    reveal.append("" + mineBoard.getNumberOfMines(i, j));
                }
            }
            reveal.append("\n");
        }

        return reveal.toString();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<DIM; i++) {
            for(int j=0; j<DIM; j++) {

                sb.append("\t");
                if(selectionBoard.hasPlayed(i, j)) {
                    if(mineBoard.isAMine(i, j)) {

                        sb.append('*');

                    } else {

                        sb.append(Character.forDigit(mineBoard.getNumberOfMines(i, j), 10));
                    }

                } else {

                    sb.append('_');
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
