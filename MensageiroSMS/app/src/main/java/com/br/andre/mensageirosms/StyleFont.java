package com.br.andre.mensageirosms;

/**
 * Created by andre on 03/10/16.
 */

public class StyleFont {

    public StyleFont(){}

    public String negrito(String texto) {

        String textoModificado = "*" + texto + "*";

        return textoModificado;
    }

    public String italico(String texto) {

        String textoModificado = "_" + texto + "_";

        return textoModificado;
    }

    public String riscado(String texto) {

        String textoModificado = "~" + texto + "~";

        return textoModificado;
    }

    public String alterado(String texto) {

        String textoModificado = "```" + texto + "```";

        return textoModificado;
    }


}
