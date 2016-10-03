package com.br.andre.smsregistro;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by andre on 18/09/16.
 */
public class GravarEmArquivo extends MainActivity {

    //private static final String TAG = "ManageFile";
    private Context context;

    public GravarEmArquivo(Context context){
        this.context = context;
    }

    private String numero, texto;

    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }

    private String ObterDiretorio() {
        File root = Environment.getExternalStorageDirectory();
        return root.toString();
    }

    private String nomeArq = "sms.txt";;
    private File arq;
    private byte[] dados, buffer;
    String caminhoArquivo = Environment.getExternalStorageDirectory().toString();

    public void salvar() {


        try {

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

    public String lerArquivo()  {

        String result;
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.sms);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            result = new String(b);
        } catch (Exception e) {
            // e.printStackTrace();
            result = "Error: can't show file.";
        }

        return result;
    }

    public void escreverArquivo()  {

        String result;

        try {


        } catch (Exception e) {
            // e.printStackTrace();
            result = "Error: can't show file.";
        }


    }

    public void escrever() {

        try {

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
