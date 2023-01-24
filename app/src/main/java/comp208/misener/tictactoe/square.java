package comp208.misener.tictactoe;



//Tag
public class square {

    int col;
    int row;
    public int resourceId;

    public square(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
