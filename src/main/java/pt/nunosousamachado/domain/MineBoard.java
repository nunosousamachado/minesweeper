package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 21/05/17.
 */
public class MineBoard {

    private static final int MAX_MINES = 10;
    private static final int MINE = -1;

    private int[][] mineBoard;

    public MineBoard() {
        this.mineBoard = new int[10][10];
        this.generateMines();
        this.generateNumberOfMines();
    }

    public int getTotalNumberMines() {

        int count = 0;

        for(int i=0; i<mineBoard.length; i++) {
            for(int j=0; j<mineBoard[i].length; j++) {

                if(mineBoard[i][j]==MINE){
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumberOfMinesArround(int x, int y) {

        return mineBoard[x][y];
    }

    public boolean isAMine(int x, int y) {

        return mineBoard[x][y] == MINE;
    }

    private void generateMines() {

        int count = 0;

        for(int i = 0; i< mineBoard.length; i++) {
            for(int j = 0; j< mineBoard[i].length; j++) {

                if(Math.random()<=0.15 && count < MAX_MINES) {

                        mineBoard[i][j] = MINE;
                        count++;
                }
            }
        }
    }

    private void generateNumberOfMines() {

        for(int i = 0; i< mineBoard.length; i++) {
            for(int j = 0; j< mineBoard[i].length; j++){
                if(mineBoard[i][j] != MINE) {

                    mineBoard[i][j] = numberOfMines(i, j);
                }
            }
        }

    }

    private int numberOfMines(int x, int y) {

        int numbMines = 0;
        int startRow = x==0 ? 0 : x-1;
        int endRow = x== mineBoard.length-1 ? mineBoard.length-1 : x+1;
        int startCollumn = y==0 ? 0 : y-1;
        int endCollumn = y== mineBoard[x].length-1 ? mineBoard[x].length-1 : y+1;

        for(int i=startRow; i<=endRow; i++) {
            for(int j=startCollumn; j<=endCollumn; j++) {
                if(mineBoard[i][j]==MINE && (i!=x || j!=y)) {
                    numbMines++;
                }
            }
        }

        return numbMines;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< mineBoard.length; i++) {
            for(int j = 0; j< mineBoard[i].length; j++) {

                sb.append("\t");
                sb.append(mineBoard[i][j]);
            }

            sb.append("\n");
        }

        return sb.toString();

    }
}
