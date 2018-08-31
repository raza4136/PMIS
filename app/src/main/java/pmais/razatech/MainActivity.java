package pmais.razatech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pmais.razatech.db.DBHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler db = new DBHandler(this);
        db.getWritableDatabase();
    }

    public void login(View view) {
    }
}