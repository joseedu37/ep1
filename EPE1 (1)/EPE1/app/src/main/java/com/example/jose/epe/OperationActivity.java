package com.example.jose.epe;

//Alejandro Jesús Pizarro Gutiérrez
//janoxsky2013@gmail.com

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.jose.epe1.R;

public class OperationActivity extends Activity{

    //Solemnes
    private EditText etEPR1;
    private EditText etEPE1;
    private EditText etEPR2;
    private EditText etEPE2;
    //Acumulativas
    private EditText etEVA1;
    private EditText etEVA2;
    private EditText etEVA3;
    private EditText etEVA4;
    //boton calcular
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Solemnes
        etEPR1 = (EditText) findViewById(R.id.etEPR1);
        etEPE1 = (EditText) findViewById(R.id.etEPE1);
        etEPR2 = (EditText) findViewById(R.id.etEPR2);
        etEPE2 = (EditText) findViewById(R.id.etEPE2);
        //Acumulativas
        etEVA1 = (EditText) findViewById(R.id.etEVA1);
        etEVA2 = (EditText) findViewById(R.id.etEVA2);
        etEVA3 = (EditText) findViewById(R.id.etEVA3);
        etEVA4 = (EditText) findViewById(R.id.etEVA4);
        //boton calcular
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Validacion campos vacios
                if(etEPR1.getText().toString().equals("") || etEPE1.getText().toString().equals("") || etEPR2.getText().toString().equals("") || etEPE2.getText().toString().equals("") ||
                        etEVA1.getText().toString().equals("") || etEVA2.getText().toString().equals("") || etEVA3.getText().toString().equals("") || etEVA4.getText().toString().equals("")){
                    Context contexto = getApplicationContext();
                    Toast.makeText(contexto, "Rellena todo los campos", Toast.LENGTH_SHORT).show();
                }else{
                    //Calculo de notas

                    //Solemnes
                    double Epr1 = Double.valueOf(etEPR1.getText().toString()).doubleValue();
                    double Epe1 = Double.valueOf(etEPE1.getText().toString()).doubleValue();
                    double Epr2 = Double.valueOf(etEPR2.getText().toString()).doubleValue();
                    double Epe2 = Double.valueOf(etEPE2.getText().toString()).doubleValue();

                    Epr1 = (Epr1 * 0.10);
                    Epe1 = (Epe1 * 0.15);
                    Epr2 = (Epr2 * 0.20);
                    Epe2 = (Epe2 * 0.25);

                    //Evas
                    double Eva1 = Double.valueOf(etEVA1.getText().toString()).doubleValue();
                    double Eva2 = Double.valueOf(etEVA2.getText().toString()).doubleValue();
                    double Eva3 = Double.valueOf(etEVA3.getText().toString()).doubleValue();
                    double Eva4 = Double.valueOf(etEVA4.getText().toString()).doubleValue();

                    double Evas = (((Eva1+Eva2+Eva3+Eva4)/4)*0.30);

                    //PromedioFinal

                    double promedioFinal = Epr1+Epe1+Epr2+Epe2+Evas;

                    //Imprimir nota
                    Context contexto = getApplicationContext();
                    Toast.makeText(contexto, "Promedio Final: "+String.format("%.1f", promedioFinal), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
