package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 21/05/17.
 */
public class SelectionBoard {

    private static final int PLAYED = 1;
    private static final int NOT_PLAYED = 0;

    private int[][] selectionBoard;


    public SelectionBoard() {

        this.selectionBoard = new int[10][10];

    }

    public void registerSelection(int x, int y) throws IllegalSelectionException {

        if((x < 0 || x > 9) || (y < 0 || y > 9)) {

            throw new IllegalSelectionException("Invalid coordinates! Play again.");
        }

        if(selectionBoard[x][y] == PLAYED) {

            throw new IllegalSelectionException("You have selected this coordinates before! Play again.");
        }

        selectionBoard[x][y] = PLAYED;

    }

    public boolean hasPlayed(int x, int y) {

        return selectionBoard[x][y] == PLAYED;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<selectionBoard.length; i++) {
            for(int j=0; j<selectionBoard[i].length; j++) {

                sb.append("\t");
                sb.append(selectionBoard[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
