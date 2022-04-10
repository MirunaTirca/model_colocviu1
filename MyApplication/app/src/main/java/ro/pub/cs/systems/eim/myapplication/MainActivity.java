package ro.pub.cs.systems.eim.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText leftEditText, rightEditText;
    private Button leftButton, rightButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        public void onClick(View view) {
            int leftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
            int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

            switch (view.getId()) {
                case R.id.left_button:
                    leftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(leftNumberOfClicks));
                    break;
                case R.id.right_button:
                    rightNumberOfClicks++;
                    rightEditText.setText(String.valueOf(rightNumberOfClicks));
                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftEditText = (EditText) findViewById(R.id.left_edit_text);
        rightEditText = (EditText) findViewById(R.id.right_edit_text);

        leftButton = (Button) findViewById(R.id.left_button);
        rightButton = (Button) findViewById(R.id.right_button);

        leftEditText.setText(String.valueOf(0));
        rightEditText.setText(String.valueOf(0));

        leftButton.setOnClickListener(buttonClickListener);
        rightButton.setOnClickListener(buttonClickListener);

    }
}