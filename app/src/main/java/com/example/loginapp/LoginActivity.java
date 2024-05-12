package com.example.loginapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edtUsername = binding.edtUsername;
        EditText edtPassword = binding.edtPassword;
        Button btnLogin = binding.btnLogin;
        Button btnRegister = binding.btnAddAccount;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if(intent != null) { // Comprueba si existe el intent
                    EntidadCuenta dates = (EntidadCuenta) intent.getSerializableExtra("dates");
                    if(dates != null) {
                        String userName = dates.getUserName();
                        String passWord = dates.getPassword();

                        if (edtUsername.getText().toString().equals(userName) && edtPassword.getText().toString().equals(passWord)){
                            Toast.makeText(getApplicationContext(), "Bienvenido a mi APP", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Bienvenido a mi APP");

                            // Se inicia un intent para ir a HomeActivity y enviar al usuario
                            Intent intentUser = new Intent(getApplicationContext(), HomeActivity.class);
                            intentUser.putExtra("user", dates.getUserName());
                            startActivity(intentUser);

                        } else {
                            Toast.makeText(getApplicationContext(), "Error de Autenticacion", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Error de Autenticacion");
                        }
                    }
                }

            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);
        });


    }
}