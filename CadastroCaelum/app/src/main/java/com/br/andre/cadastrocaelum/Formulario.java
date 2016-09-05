package com.br.andre.cadastrocaelum;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


/**
 * Created by andre on 02/09/16.
 */
public class Formulario extends AppCompatActivity {

   private FormularioHelper helper;
    private String caminhoArquivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        final Intent intent = getIntent();
        final Aluno alunoParaSerAlterado = (Aluno) intent.getSerializableExtra("alunoSelecionado");
        //Toast.makeText(this, "Aluno: " + alunoParaSerAlterado, Toast.LENGTH_LONG).show();

        helper = new FormularioHelper(this);

        Button botao = (Button) findViewById(R.id.botao);

        if (alunoParaSerAlterado != null){
            botao.setText("Alterar");
            helper.colocaAlunoNoFormulario(alunoParaSerAlterado);
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Aluno aluno = helper.pegaAlunoDoFormulario();

                AlunoDAO dao = new AlunoDAO(Formulario.this);

                //Caso o aluno seja null então ele salva, caso contrario altera
                if (alunoParaSerAlterado == null) {
                    dao.salva(aluno);
                }else {
                    aluno.setId(alunoParaSerAlterado.getId());
                    dao.altera(aluno);
                }

                dao.close();

                finish(); // Faz o papel do botão VOLTAR
            }
        });

        ImageView foto = helper.getFoto();

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent implícita
                Intent irParaCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                caminhoArquivo = Environment.getExternalStorageDirectory().toString()
                +"/"+ System.currentTimeMillis()+".png";

                File arquivo = new File(caminhoArquivo);

                Uri localImagem = Uri.fromFile(arquivo);

                irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, localImagem);

                startActivityForResult(irParaCamera,123);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){

                helper.carregaImagem(caminhoArquivo);

            }else {

                caminhoArquivo = null;

            }
        }
    }

}
