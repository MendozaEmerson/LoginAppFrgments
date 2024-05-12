package com.example.loginapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.databinding.ActivityMainBinding;

public class AccountActivity extends AppCompatActivity {
    //private AccountActivity binding;
    private EntidadCuenta account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        final EditText firstName = findViewById(R.id.edtFirstName);
        final EditText lastName = findViewById(R.id.edtLastName);
        final EditText email = findViewById(R.id.edtEmail);
        final EditText phone = findViewById(R.id.edtPhone);
        final EditText user = findViewById(R.id.edtUserNameRegister);
        final EditText password = findViewById(R.id.edtPassWordRegister);

        final Button btnOk = findViewById(R.id.btnOk);
        final Button btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Transformacion de los datos en Strings
                final String firstNameTxt = firstName.getText().toString();
                final String lastNameTxt = lastName.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String userTxt = user.getText().toString();
                final String passwordTxt = password.getText().toString();

                // Comprobación del llenado de todos los campos
                if (firstNameTxt.isEmpty() || lastNameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty()
                        || userTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(AccountActivity.this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Se crea una nueva instancia de EntidadCuenta
                    account = new EntidadCuenta();

                    // Se llena los datos en la instancia de la clase EntidadCuenta
                    account.setFirstName(firstNameTxt);
                    account.setLastName(lastNameTxt);
                    account.setEmail(emailTxt);
                    account.setPhone(phoneTxt);
                    account.setUserName(userTxt);
                    account.setPassword(passwordTxt);
                    // Se inicia un intent con direccion a la actividad login
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("dates", account); // Se inserta la instancia account al intent
                    Toast.makeText(AccountActivity.this, "Se enviaron los datos!!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Envio satisfactorio");
                    startActivity(intent);

                }
            }
        });

    }
}