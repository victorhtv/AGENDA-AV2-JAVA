package com.br.andre.aula02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome, sobrenome;
    private TextView textView_nomeCompleto;
    private Button b, bLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cria os objetos do layout atraves do id
        this.nome = (EditText) findViewById(R.id.edtxt_nome);
        this.sobrenome = (EditText) findViewById(R.id.edtxt_sobrenome);
        this.textView_nomeCompleto = (TextView) findViewById(R.id.txt_nomeCompleto);
        this.b = (Button) findViewById(R.id.btn_concatena);
        this.bLog = (Button) findViewById(R.id.btn_log);

        //Ação ao clicar no botão
        b.setOnClickListener(new View.OnClickListener(){

            //Função de concatenar
            public void onClick(View v) {

                String nomeCompleto =  nome.getText() + " " +  sobrenome.getText();

                textView_nomeCompleto.setText(nomeCompleto);

            }
        });

        bLog.setOnClickListener(new View.OnClickListener(){

            //Função de concatenar
            public void onClick(View v) {
                //Mostra a mensagem no console
                Log.i("TAG","Botão Log Clicado!");
                //Mostra o nome completo em uma pop up com logo tempo de duração
                Toast.makeText(MainActivity.this, textView_nomeCompleto.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
