package id.ac.polinema.latihanutsdua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    SessionManagement sessionManagement;
    TextView tvUsername;
    Button btnDb , btnLgout;
    HashMap<String, String> loginUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        btnDb = (Button) findViewById(R.id.btnDb);
        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();
        btnLgout = findViewById(R.id.btnLgout);

        Toast.makeText(this,sessionManagement.isLoggedIn() +"",Toast.LENGTH_LONG).show();

        tvUsername.setText(loginUser.get(sessionManagement.KEY_USERNAME));

        btnDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sessionManagement.LogoutUser();
                goToInsert();
            }
        });

        btnLgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.LogoutUser();
                goToLogout();
            }
        });
    }
    private void goToInsert() {
        Intent mIntent = new Intent(getApplicationContext(),
                Main3Activity.class);
        startActivity(mIntent);

    }

    private void goToLogout() {
        Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mIntent);

    }
}
