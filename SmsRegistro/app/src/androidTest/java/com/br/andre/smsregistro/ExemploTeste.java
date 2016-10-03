package com.br.andre.smsregistro;

import android.content.Context;
import android.test.InstrumentationTestCase;

/**
 * Created by andre on 20/09/16.
 */
public class ExemploTeste extends InstrumentationTestCase {

    public void testeClasse(Context context) throws Exception{

        GravarEmArquivo g = new GravarEmArquivo(context);

        g.setTexto("Andre Riggs");
        g.escrever();
    }
}
