package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 17/06/17.
 */
public class BoardField {

    private static final int MINE = -1;
    private int value;
    private FieldStatus status;

    public BoardField() {
        this.value = 0;
        this.status = FieldStatus.CLOSED;
    }

    public int getNumberofMinesAround() {

        if(isAMine()) {

            throw new IllegalStateException("This field is a Mine!");
        }

        return this.value;
    }

    public void setNumberOfMinesAround(int value) {

        if(isAMine()) {

            throw new IllegalStateException("This field is a Mine!");
        }

        this.value = value;
    }

    public void setMine() {

        this.value = MINE;
    }

    public boolean isAMine() {

        return value == MINE;
    }

}
