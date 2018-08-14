package my.xpert.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView numberTextView;
    EditText numberEditText;
    int numberToGuess;
    int numberOfTry;
    boolean gameOn;
    Button buttonReset, guessBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.number_textView);
        numberEditText = findViewById(R.id.number_editText);
        buttonReset = findViewById(R.id.buttonReset);
        guessBtn = findViewById(R.id.buttonGuess);
        initializeGame();
        Log.d("debug","generated number is "+numberToGuess);

    }

    private void initializeGame() {
        numberToGuess = (int) (Math.random() * 100);
        numberOfTry = 3;
        gameOn = true;
        numberEditText.setText("");
        numberTextView.setText("");
        buttonReset.setVisibility(View.GONE);
        guessBtn.setVisibility(View.VISIBLE);
    }

    public void run_random(View view) {
        if(numberEditText.getText().toString().equals("")) {

            Toast.makeText(MainActivity.this,"Please enter a number", Toast.LENGTH_LONG).show();

        } else {
            numberOfTry--;
            int numberGuess = Integer.parseInt(numberEditText.getText().toString());

            if (numberGuess > numberToGuess) {

                numberTextView.setText("Number too high. Try again!");

            } else if (numberGuess < numberToGuess) {

                numberTextView.setText("Number too low. Try again!");

            } else {
                numberTextView.setText("Congratulations you win!");
                gameOn = false;
                buttonReset.setVisibility(View.VISIBLE);
                guessBtn.setVisibility(View.GONE);
            }

            if (numberOfTry == 0 && gameOn){
                numberTextView.setText("Sorry you lost. The number is "+numberToGuess);
                gameOn = false;
                buttonReset.setVisibility(View.VISIBLE);
                guessBtn.setVisibility(View.GONE);
            }

        }
    }

    public void resetGame(View view) {
        initializeGame();
    }
}
