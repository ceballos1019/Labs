package co.edu.udea.compumovil.gr8.lab2apprun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario=((EditText)findViewById(R.id.editText)).getText().toString();
                String password=((EditText)findViewById(R.id.editText2)).getText().toString();
                if(usuario.equals("sergio")&&password.equals("asdfgh")){
                    Intent actividad2=new Intent(MainActivity.this,Carreras.class);
                    startActivity(actividad2);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
