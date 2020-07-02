package cl.talentodigital.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAceptar;
    private Button btnRegistrar;
    private Button btnSalir;
    private EditText eTxtUsuario;
    private EditText eTxtpassword;

    private String usuario ="admin";
    private String contrasena ="admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnSalir = findViewById(R.id.btnSalir);
        eTxtUsuario = findViewById(R.id.eTxtUsuario);
        eTxtpassword = findViewById(R.id.eTxtContraseña);

        btnAceptar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAceptar:
                if(eTxtUsuario.getText().toString().equals(usuario) && eTxtpassword.getText().toString().equals(contrasena)){
                    Toast.makeText(this, "Usuario Valido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, UserMenu.class);
                    this.startActivity(intent);
                }else if(!eTxtUsuario.getText().toString().equals(usuario) || !eTxtpassword.getText().toString().equals(contrasena)){
                    Toast.makeText(this, "Usuario o Contraseña Invalida", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrar:
                Toast.makeText(this, "Ingrese en www.Registro.cl", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSalir:
                finish();
                break;
        }

    }
}
