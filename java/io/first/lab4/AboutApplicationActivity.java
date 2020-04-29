package io.first.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_application);

        Button button = findViewById(R.id.buttonForCollor);
        button.setOnClickListener(v->{
            v.getRootView().setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");

        TextView textView = findViewById(R.id.textview2);
        textView.setText("Hello, "+name+" "+surname);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_activity_menu, menu);
        return true;
    }

    public void onMenuFirstActivityClicked(MenuItem menuItem){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
