package com.example.samue.calculadoradegorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValor;
    private SeekBar seekBarGorjeta;
    private TextView textViewPorcentagem;
    private TextView textViewGorjeta;
    private TextView textViewTotal;

    //porcetagem inicial da gorjeta
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);

        //Controlar seekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                textViewPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        //Recuperar valor digitado
        Double valorDigitado = Double.parseDouble(editTextValor.getText().toString());

        //calcula a gorjeta total
        double gorjeta = valorDigitado * porcentagem/100;
        double total = gorjeta + valorDigitado;

        //exibe a gorjeta e o total
        textViewGorjeta.setText("R$ " + gorjeta);
        textViewTotal.setText("R$ "+ total);
    }
}
