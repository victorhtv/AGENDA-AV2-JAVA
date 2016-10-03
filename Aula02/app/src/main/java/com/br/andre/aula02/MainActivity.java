package com.br.andre.aula02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nome, sobrenome;
    private TextView textView_nomeCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cria os objetos do layout atraves do id
        this.nome = (EditText) findViewById(R.id.edtxt_nome);
        this.sobrenome = (EditText) findViewById(R.id.edtxt_sobrenome);
        this.textView_nomeCompleto = (TextView) findViewById(R.id.txt_nomeCompleto);

        //Opções Adicionais
        this.b = (Button) findViewById(R.id.btn_concatena);

        //Ação ao clicar no botão
        b.setOnClickListener(new View.OnClickListener() {

            //Função de concatenar
            public void onClick(View v) {
                concatena();

            }
        });

    }

    private String concatena() {

        String nomeCompleto = this.nome.getText() + " " + this.sobrenome.getText();

        return nomeCompleto;
    }
}






