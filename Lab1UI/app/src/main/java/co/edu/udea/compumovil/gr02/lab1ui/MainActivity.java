package co.edu.udea.compumovil.gr02.lab1ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private AutoCompleteTextView autocomplete;
        private ArrayAdapter<String> adapter;
        private ArrayAdapter<String> adapter2;
        private Spinner lista;
        private Button Mostrar;
        private TextView texto;
        private EditText nombre,apellido,telefono,direccion,email;
        private DatePicker datePicker;
        private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        establecerUI();
    }

    public void establecerUI(){
        //Se obtiene el string usando getresources
        String pais[]= getResources().getStringArray(R.array.Pais);
        String hobbies[]= getResources().getStringArray(R.array.hobbies);

        //Crea adaptador
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pais);
        adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,hobbies);

        //Registra autocomplete
        autocomplete= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        lista=(Spinner) findViewById(R.id.spinner);
        Mostrar=(Button) findViewById(R.id.button);
        texto=(TextView) findViewById(R.id.textView4);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        checkbox=(CheckBox) findViewById(R.id.checkBox);

        //Identificar los demas views
        nombre=(EditText) findViewById(R.id.editText);
        apellido=(EditText) findViewById(R.id.editText2);
        telefono=(EditText)findViewById(R.id.editText3);
        direccion=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText5);

        //Configurar adaptador para el autocomplete
        autocomplete.setAdapter(adapter);
        autocomplete.setThreshold(1);
        lista.setAdapter(adapter2);

    }

    public void mostrarInfoContacto(View v){

        //Capturamos los datos ingresados
        String txtNombre = nombre.getText().toString();
        String txtApellido = apellido.getText().toString();
        String txtPais = autocomplete.getText().toString();
        String txtTelefono = telefono.getText().toString();
        String txtDireccion = direccion.getText().toString();
        String txtEmail = email.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        //Validamos que todos los campos sean llenados
        boolean infoCompleta = true;
        RadioGroup grupo= (RadioGroup) findViewById(R.id.grupo);
        RadioButton radioChecked;
        int selectedRadio=grupo.getCheckedRadioButtonId();
        if(selectedRadio==-1){
            infoCompleta=false;
        }
        if(TextUtils.isEmpty(txtNombre))infoCompleta=false;
        if(TextUtils.isEmpty(txtApellido)) infoCompleta=false;
        if(TextUtils.isEmpty(txtPais)) infoCompleta=false;
        if(TextUtils.isEmpty(txtTelefono)) infoCompleta=false;
        if(TextUtils.isEmpty(txtDireccion)) infoCompleta=false;
        if(TextUtils.isEmpty(txtEmail)) infoCompleta=false;
        if(!infoCompleta) {
            Toast.makeText(this,"Revise que todos los campos esten completos",Toast.LENGTH_SHORT).show();
            return;
        }
        radioChecked = (RadioButton) findViewById(selectedRadio);
        String txtSexo = radioChecked.getText().toString();

        //Desplegamos la informacion en el EditText
        texto.setText("");
        texto.append(getString(R.string.nombre, txtNombre));
        texto.append(getString(R.string.apellido, txtApellido));
        texto.append(getString(R.string.sexo, txtSexo));
        texto.append(getString(R.string.pais, txtPais));
        texto.append(getString(R.string.telefono, txtTelefono));
        texto.append(getString(R.string.direccion, txtDireccion));
        texto.append(getString(R.string.email, txtEmail));
        texto.append(getString(R.string.fecha_nacimiento, day, month, year));
        texto.append("\n"+lista.getSelectedItem().toString());
        if(checkbox.isChecked()){
            texto.append("\nContacto favorito");
        }


    }
}
