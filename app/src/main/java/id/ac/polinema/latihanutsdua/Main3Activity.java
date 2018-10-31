package id.ac.polinema.latihanutsdua;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Cursor cursor;
    DataHelper dbHelper;
    Button btnSim,cek;
    EditText txtKota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dbHelper = new DataHelper(this);
        txtKota = findViewById(R.id.txtKota);
        btnSim = findViewById(R.id.btnSim);
        cek = findViewById(R.id.btnCek);

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO kota ( nama) VALUES ('" +
                        txtKota.getText().toString()+"') ");

                //Intent i = new Intent(getApplicationContext(), Main4Activity.class);
                //startActivity(i);
                Toast.makeText(getApplicationContext(), "Tambah Kota Success", Toast.LENGTH_SHORT).show();
                //finish();
            }
        });
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTocek();
            }
        });
    }
    private void emptyEditText(){
        txtKota.setText(null);
    }
    private void goTocek(){
        Intent mIntent = new Intent(getApplicationContext(),
                Main4Activity.class);
        startActivity(mIntent);
    }
}