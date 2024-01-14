package com.example.registroactividadesfisicas;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Boolean registro = true;
    Button btnRegistro;
    Button btnConsulta;
    EditText km;
    EditText nombre;
    RadioGroup radioGroup;
    RadioButton rPlaya;
    RadioButton rMontaña;
    RadioButton rUrbano;
    int lugar;
    ArrayList<Lugares> sitios = new ArrayList<Lugares>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        // Recuperar la lista desde SharedPreferences al iniciar la Activity

    }
    public void Init()
    {
        btnRegistro = findViewById(R.id.btnRegistro);
        btnConsulta = findViewById(R.id.btnConsulta);
        km = findViewById(R.id.km);
        nombre = findViewById(R.id.nombre);
        radioGroup = findViewById(R.id.radioGroup);
        rPlaya = findViewById(R.id.rPlaya);
        rUrbano = findViewById(R.id.rUrbano);
        rMontaña = findViewById(R.id.rMontaña);



    }

    public void  registrar(View view) {
        int radBtn = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radBtn);
        String kms = km.getText().toString().trim();
        String nombres = nombre.getText().toString().trim();
        int  tipoLugar = obtLugar(rPlaya, rUrbano, rMontaña, radioButton);


        // Verificar si los campos están vacíos o si no hay RadioButton seleccionado
        if (kms.isEmpty() || nombres.isEmpty() || radBtn == -1) {
            Toast.makeText(getApplicationContext(), "Al menos uno de los campos está vacío", Toast.LENGTH_LONG).show();
            registro = false; // Al menos uno de los campos está vacío o no hay RadioButton seleccionado

        } else {
           // Lugares lugar = new Lugares(kms, nombres, tipoLugar);

            // Agregar el objeto Lugares a la lista
          //  sitios.add(new Lugares(kms,nombres));
            System.out.println("Pasa");
            Intent i = new Intent(MainActivity.this, Resultados.class);
            i.putExtra("km",kms);
            i.putExtra("nombre",nombres);
            i.putExtra("tipoLugar",tipoLugar);
            startActivity(i);
            registro = true; // Todos los campos están llenos y hay un RadioButton seleccionado

            // Realizar acciones de registro, si es necesario
          //  recuperarListaDesdeSharedPreferences();

        }
    }
   private int  obtLugar(RadioButton rPlaya, RadioButton rUrbano, RadioButton rMontaña, RadioButton radioButton) {
        if (radioButton == rPlaya) {
            System.out.println("Tipo de lugar: Playa");
            return 1;
        } else if (radioButton == rUrbano) {
            System.out.println("Tipo de lugar: Urbano");
            return 2;
        } else if (radioButton == rMontaña) {
            System.out.println("Tipo de lugar: Montaña");
            return 3;
        } else {
            System.out.println("Tipo de lugar: Valor por defecto o manejo de error");
            return 0; // Valor por defecto o manejo de error
        }

}
  public void consulta (View v){
      Intent i = new Intent(MainActivity.this, Resultados.class);
      startActivity(i);
  }
}

