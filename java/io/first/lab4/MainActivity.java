package io.first.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    public void onMenuNextActivityClicked(MenuItem menuItem){
        openActivity2();
    }

    public void onMenuFirstNameClicked(MenuItem menuItem){
        EditText editText = findViewById(R.id.edittext1);
        editText.setText("Andrii");
    }

    public void onMenuSecondNameClicked(MenuItem menuItem){
        EditText editText = findViewById(R.id.edittext2);
        editText.setText("Melnyk");
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
