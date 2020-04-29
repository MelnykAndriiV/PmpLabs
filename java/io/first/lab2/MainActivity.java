package io.first.lab2;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v)-> {
                rotate();
            });

        Button greetingsButton = findViewById(R.id.greetings);
        greetingsButton.setOnClickListener((v)->{
            greetings();
        });
        if(savedInstanceState!=null) {
            TextView tv = findViewById(R.id.textViewGreetings);
            tv.setText(savedInstanceState.getString("Text"));
        }
    }

    private void greetings() {
        EditText editText1 = findViewById(R.id.edittext1);
        String name = editText1.getText().toString();
        EditText editText2 = findViewById(R.id.edittext2);
        String surname = editText2.getText().toString();

        TextView tv = findViewById(R.id.textViewGreetings);
        String text = "Hello, "+name+" "+surname;
        tv.setText(text);
    }

    public void rotate() {
        int orientation = getRequestedOrientation();
        if(orientation != Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }, 4000);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView tv = findViewById(R.id.textViewGreetings);
        outState.putString("Text", tv.getText().toString());
    }
}
