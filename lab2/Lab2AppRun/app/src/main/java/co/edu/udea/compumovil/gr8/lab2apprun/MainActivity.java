package co.edu.udea.compumovil.gr8.lab2apprun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,password;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        btnAgregar=(Button)findViewById(R.id.button2);
        btnAgregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(MainActivity.this, Agregar.class);
                startActivity(agregar);
            }
                     });
        }









}
