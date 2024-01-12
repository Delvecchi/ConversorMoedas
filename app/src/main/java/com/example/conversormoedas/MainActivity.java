package com.example.conversormoedas;

import android.os.Bundle;
import android.view.TextureView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.conversormoedas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //declaração do espaço do retorno(resultado)
    private TextView resultado;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Começa aqui
        //metodo = chamar por id(caminho até o id), localização armazenada em resultado
        resultado = findViewById(R.id.txt_resultado);
        //declarar botão
        // elemento metodo = chamar por id(caminho até o id)
        Button botaoConverter = findViewById(R.id.btn_converter);
        //identificar a ação para o notão funcionar
        //metodo onclick(ao clicar)
        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //declarar a lógica para o calculo conforme o radio seleconado
                converter();
            }

            private void converter() {
                //lógica, qual radio selecionado, qual valor
                //chamar o radio group, armazena dados do radiogroup
                RadioGroup opcoes = findViewById(R.id.radio_opcoes);
                //variavel = metodo.qual a opçao selecionada
                int selecionada = opcoes.getCheckedRadioButtonId();
                //valor imputado
                EditText valor = findViewById(R.id.input_valor);

                //armazenar valor já convertido
                double valorConvertido = 0.0;

                if (selecionada == R.id.radio_usd) {
                    //transformando valor int para valor double
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    //valor convertido para dolar
                    valorConvertido = valorCalculado * 4.87;
                } else if (selecionada == R.id.radio_eur) {
                    //transformando valor int para valor double
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    //valor convertido para euro
                    valorConvertido = valorCalculado * 5.35;
                } else {
                    //transformando valor int para valor double
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    //valor convertido para peso chileno
                    valorConvertido = valorCalculado * 0.0054;
                }

                //setar o valor, o resultado
                resultado.setText(String.valueOf(valorConvertido));
                //mudar a visualização do elemento para visivel
                resultado.setVisibility(View.VISIBLE);
            }
        });

    }
}