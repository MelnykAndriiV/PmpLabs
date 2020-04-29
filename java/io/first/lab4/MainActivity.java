package io.first.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v)-> {
                createMenu(v);
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    public void createMenu(View v) {
        PopupMenu pm = new PopupMenu(this,v);
        pm.inflate(R.menu.main_activity_menu_popup);
        pm.setOnMenuItemClickListener(i->{
            switch (i.getItemId()){
                case R.id.nextActivity:
                    openActivity2();
                case R.id.firstName:
                    onMenuFirstNameClicked(i);
                case R.id.secondName:
                    onMenuSecondNameClicked(i);
                case R.id.toast:
                    getToast().show();
                    getToastImg().show();
            }
            return true;
        });
        pm.show();
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

    public Toast getToast(){
        Toast toast = Toast.makeText(getApplicationContext(),"Звучить як toast",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        return toast;
    }

    public Toast getToastImg(){
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.toast);
        Toast toast = Toast.makeText(getApplicationContext(),"",
                Toast.LENGTH_LONG);
        toast.setView(img);
        return toast;
    }
}
