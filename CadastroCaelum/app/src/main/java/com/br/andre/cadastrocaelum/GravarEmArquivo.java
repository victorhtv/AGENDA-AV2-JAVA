package com.br.andre.cadastrocaelum;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by andre on 18/09/16.
 */
public class GravarEmArquivo extends Formulario {

    private String numero, texto;

    public void getNumero(String numero){
        this.numero = numero;
    }

    public void getTexto(String texto){
        this.texto = texto;
    }

    private String ObterDiretorio()
    {
        File root = android.os.Environment.getExternalStorageDirectory();
        return root.toString();
    }

    public void salvar()
    {
        String nomeArq;
        File arq;
        byte[] dados;

        try
        {

            nomeArq = "sms.txt";


           String caminhoArquivo = Environment.getExternalStorageDirectory().toString();

            arq = new File(caminhoArquivo, nomeArq);

            FileOutputStream fos;

            dados = texto.getBytes();

            fos = new FileOutputStream(arq);
            fos.write(dados);
            fos.flush();
            fos.close();

        }
        catch (Exception e)
        {

        }
    }
}
