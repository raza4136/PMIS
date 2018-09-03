package pmais.razatech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import pmais.razatech.db.DBTables;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {
        int addedID = DBTables.InsertData.insertDesignation(this, "Admin");
        Toast.makeText(this,"ID"+addedID,Toast.LENGTH_SHORT).show();
    }
}