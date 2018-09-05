package pmais.razatech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import pmais.razatech.db.DBTables;
import pmais.razatech.dialogboxes.SingleInput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void AddDesignation(View view) {
        final SingleInput InputAlert = new SingleInput(this, true, new int[]{0, 0}, new String[]{"Add Designation", "Administrator", "", "Save", "Cancel"},
                (buttonId, EditTextValue) -> {
                    switch (buttonId) {
                        case 1:
                            int addedID = DBTables.InsertData.insertDesignation(MainActivity.this, "Admin");
                            Toast.makeText(MainActivity.this, "Added With ID " + addedID, Toast.LENGTH_SHORT).show();

                            break;
                        case 0:
                            break;
                        default:
                            break;
                    }
                });
        InputAlert.show();
    }
}