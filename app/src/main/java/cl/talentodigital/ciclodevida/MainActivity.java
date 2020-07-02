package cl.talentodigital.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Crear variables en que se asiganan las cajas de texto y botones
    private Button btnAceptar;
    private Button btnRegistrar;
    private Button btnSalir;
    private EditText eTxtUsuario;
    private EditText eTxtpassword;

    //user y pass genericos asignados en duro
    private String usuario ="admin";
    private String contrasena ="admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos el nombre del variable y traemos el recurso del XML con su nombre
        //ejemplo   NombreVariable = findViewById(R.id.Recurso_XML);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnSalir = findViewById(R.id.btnSalir);
        eTxtUsuario = findViewById(R.id.eTxtUsuario);
        eTxtpassword = findViewById(R.id.eTxtContraseña);

        //Activamos los listener de los botones con el nomrbe del boton mas "setOnClickListener(this);" El "(this) hace referencia a ESTA clase
        btnAceptar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //uso Switch para generar los usos de los botones
        switch (v.getId()){
            case R.id.btnAceptar:
                //al apretar el boton aceptar, se aplica lo siguiente, el if compara lo escrito en las cajas de texto con los  datos de usurio expuestos anteriormente
                if(eTxtUsuario.getText().toString().equals(usuario) && eTxtpassword.getText().toString().equals(contrasena)){
                    Toast.makeText(this, "Usuario Valido", Toast.LENGTH_SHORT).show();
                    //Intent para pasar a otro activity, no se como explicarlo mejor xD
                    Intent intent = new Intent(this, UserMenu.class);
                    this.startActivity(intent);
                 //este else if, comprueba si alguno de los datos otorgados esta mal, tira una burbuja con la informacion no valida
                }else if(!eTxtUsuario.getText().toString().equals(usuario) || !eTxtpassword.getText().toString().equals(contrasena)){
                    Toast.makeText(this, "Usuario o Contraseña Invalida", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrar:
                //tira una burbuja con texto
                Toast.makeText(this, "Ingrese en www.Registro.cl", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSalir:
                //para salir de la aplicacion, ponemos finish gg ez
                finish();
                break;
        }

    }
}
