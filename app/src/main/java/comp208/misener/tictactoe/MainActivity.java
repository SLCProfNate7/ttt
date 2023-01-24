package comp208.misener.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
/*
* We need to know: who's turn is it?
* Should we place an X or O down
*
* Clear implimentation
*
*
* Nice to Haves: Player order count (Player X's turn)
* Game over logic
*
*
* */
    boolean playerX = true;

    int col = 3;
    int row = 3;
    square[][] ttt = new square[col][row];
    TableLayout board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = (TableLayout)findViewById(R.id.tttBoard);
        setTags();
    }


    //sets tags for each square
    public void setTags(){
        for(int  x = 0; x < row; x++) {
            TableRow tr = (TableRow) board.getChildAt(x);
            for (int y = 0; y < col; y++) {
                ImageView iv = (ImageView) tr.getChildAt(y);
                ttt[x][y] = new square(x, y);
                ttt[x][y].setResourceId(R.drawable.blank);
                iv.setTag(ttt[x][y]);
                iv.setImageResource(R.drawable.blank);

            }
        }
    }

    public void turnBlank(View view){
        for(int  x = 0; x < row; x++) {
            TableRow tr = (TableRow) board.getChildAt(x);
            for (int y = 0; y < col; y++) {
                ImageView iv = (ImageView) tr.getChildAt(y);
                ttt[x][y].setResourceId(R.drawable.blank);
                iv.setImageResource(R.drawable.blank);
            }
        }
    }

    public  void changeImage(View view){
        ImageView img = (ImageView) view;
        square current = (square)img.getTag();
        if(current.resourceId == R.drawable.blank){
            if(playerX){
                img.setImageResource(R.drawable.x);
                current.setResourceId(R.drawable.x);
            }
            else{
                img.setImageResource(R.drawable.o);
                current.setResourceId(R.drawable.o);
            }

            //Check if won function


            //change the player's turn
            playerX = !playerX;
        }
    }

}