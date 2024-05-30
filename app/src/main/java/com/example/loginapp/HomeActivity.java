package com.example.loginapp;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.loginapp.fragments.HomeFragment;
import com.example.loginapp.fragments.MapFragment;
import com.example.loginapp.fragments.PaintingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {

    private EntidadCuenta account;
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private MapFragment mapFragment = null;
    private PaintingsFragment paintingsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = findViewById(R.id.btnNav);

        bottomNavigationView.setSelectedItemId(R.id.navHome);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navHome) {
                    homeFragment = HomeFragment.newInstance("", "");
                    loadFragment(homeFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navPainting) {
                    paintingsFragment = PaintingsFragment.newInstance("", "");
                    loadFragment(paintingsFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navMap) {
                    mapFragment = MapFragment.newInstance("", "");
                    loadFragment(mapFragment);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private  void loadFragment(Fragment fragment){
        if (fragmentManager != null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.commit();
        }
    }
        // Encuentra la referencia del TextView
//        TextView textViewUsername = findViewById(R.id.edtUsernameHome);
//        TextView textViewFirstName = findViewById(R.id.edtFirstNameHome);
//        TextView textViewLastName = findViewById(R.id.edtLastNameHome);
//        TextView textViewEmail = findViewById(R.id.edtEmailHome);
//        TextView textViewPhone = findViewById(R.id.edtPhoneHome);
//        TextView textViewPassword= findViewById(R.id.edtPasswordHome);
        /*Intent intent = getIntent();
        if(intent != null) {
            String username = (String) intent.getSerializableExtra("user");
            if(username != null){
                String message = "Bienvenido " + username;
                textViewUsername.setText(message); // Cambia el texto del TexView
            }
        }*/
//        String accountEntity = getIntent().getStringExtra("ACCOUNT");
//        Log.d("HomeActivity", accountEntity);
//
//        Gson gson = new Gson();
//        account = gson.fromJson(accountEntity, EntidadCuenta.class);
//
//        String message = "Bienvenido " + account.getUserName();
//        textViewUsername.setText(message);
//        String nameMsg = "Nombre: " + account.getFirstName();
//        textViewFirstName.setText(nameMsg);
//        String lastNameMsg = "Apellidos: " + account.getLastName();
//        textViewLastName.setText(lastNameMsg);
//        String emailMsg = "Correo: " + account.getEmail();
//        textViewEmail.setText(emailMsg);
//        String phoneMsg = "Teléfono: " + account.getPhone();
//        textViewPhone.setText(phoneMsg);
//        String passwordMsg = "Contraseña: " + account.getPassword();
//        textViewPassword.setText(passwordMsg);

}