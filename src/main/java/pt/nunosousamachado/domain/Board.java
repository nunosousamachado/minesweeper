package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 17/06/17.
 */
public class Board {

    private static final int MAX_MINES = 10;
    private int count = 0;

    private Field[][] board;

    public Board () {

        this.board = new Field[10][10];
        this.boardInit();
        this.generateMines();
        this.generateNumberOfMinesAround();
    }

    public int getTotalNumberMines() {

        return this.count;
    }

    public int getTotalNumberOfFieldsClosed() {

        int closedFields = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                Field field = board[i][j];

                if(field.getStatus() == FieldStatus.CLOSED) {

                    closedFields++;
                }
            }
        }

        return closedFields;
    }

    public Field getField(int x, int y) throws IllegalSelectionException {

        if((x<0 || x>9 ) || (y<0 || y>9)) {

            throw new IllegalSelectionException("Invalid field coordinates");
        }

        return board[x][y];
    }

    public void revealBoard() {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                Field field = board[i][j];
                field.setStatus(FieldStatus.OPENED);
            }
        }

    }

    private void boardInit() {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                board[i][j] = new Field();
            }
        }
    }

    private void generateMines() {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                if(Math.random()<0.15 && this.count<MAX_MINES) {

                    Field field = board[i][j];
                    field.setMine();
                    this.count++;
                }
            }
        }
    }

    private void generateNumberOfMinesAround() {

        for(int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {

                Field field = board[i][j];

                if(!field.isAMine()) {

                    field.setNumberOfMinesAround(numberOfMinesAround(i, j));
                }
            }
        }
    }

    //this method calculates the number of mines around a field
    private int numberOfMinesAround(int x, int y) {

        int numberMines = 0;
        int startRow = x==0 ? 0 : x-1;
        int endRow = x==board.length-1 ? board.length-1 : x+1;
        int startCollumn = y==0 ? 0 : y-1;
        int endCollumn = y==board[x].length-1 ? board[x].length-1 : y+1;

        for(int i = startRow; i<=endRow; i++) {
            for(int j = startCollumn; j<=endCollumn; j++) {

                Field field = board[i][j];

                if((i!=x || j!=y) && field.isAMine()) {

                    numberMines++;
                }
            }
        }

        return numberMines;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {

                Field field = board[i][j];
                sb.append("\t");

                if(field.getStatus() == FieldStatus.OPENED) {

                    if (!(field.isAMine())) {

                        sb.append(field.getNumberofMinesAround());

                    } else {

                        sb.append("*");
                    }
                } else if (field.getStatus() == FieldStatus.CLOSED) {

                    sb.append("_");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
