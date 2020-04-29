package io.first.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v)-> {
                openActivity2();
            });
    }

    public void openActivity2() {
        EditText editText1 = findViewById(R.id.edittext1);
        String name = editText1.getText().toString();

        EditText editText2 = findViewById(R.id.edittext2);
        String surname = editText2.getText().toString();

        Intent intent = new Intent(this, AboutApplicationActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        startActivity(intent);
    }
}
