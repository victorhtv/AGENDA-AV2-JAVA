package com.br.andre.cadastrocaelum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by andre on 02/09/16.
 */
public class Formulario extends AppCompatActivity {

   private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.formulario);

        helper = new FormularioHelper(this);

        Button botao = (Button) findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Aluno aluno = helper.pegaAlunoDoFormulario();

                AlunoDAO dao = new AlunoDAO(Formulario.this);
                dao.salva(aluno);
                dao.close();

                finish(); // Faz o papel do botão VOLTAR
            }
        });


    }

}
