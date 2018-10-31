package id.ac.polinema.latihanutsdua;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText edtUser, edtPassword;
        Button buttonLogin;
        Context mContext;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            edtUser = findViewById(R.id.inuser);
            edtPassword = findViewById(R.id.inpass);
            buttonLogin = findViewById(R.id.btnlgn);

            final SessionManagement sm = new SessionManagement(this);

            if (sm.isLoggedIn()) {
                goToActivity();
            }
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = edtUser.getText().toString();
                    String password = edtPassword.getText().toString();
                    if (email.matches("") || email.trim().isEmpty() || password.matches("") || password.trim().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Email dan Password Tidak Boleh Kosong / Space ", Toast.LENGTH_LONG).show();
                        return;
                    } else

                        sm.createLoginSession(email, password);
                    goToActivity();
                }
            });
        }
    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(),
                Main2Activity.class);
        startActivity(mIntent);

    }
}