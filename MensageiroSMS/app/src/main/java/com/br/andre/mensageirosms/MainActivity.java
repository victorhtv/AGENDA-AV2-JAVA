package com.br.andre.mensageirosms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Criado as variáveis privadas
    private EditText txt_contato, txt_mensagem;
    private Button btn_enviarWhatsapp;
    private Button btn_enviarSms;
    private CheckBox cb_negrito, cb_italico, cb_riscado, cb_alterado;
    private StyleFont styleFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperando o valor das views
        txt_contato = (EditText) findViewById(R.id.edt_contato);
        txt_mensagem = (EditText) findViewById(R.id.edt_mensagem);
        btn_enviarWhatsapp = (Button) findViewById(R.id.btn_enviar_whatsapp);
        btn_enviarSms = (Button) findViewById(R.id.btn_enviar_SMS);
        cb_negrito = (CheckBox) findViewById(R.id.cb_negrito);
        cb_italico = (CheckBox) findViewById(R.id.cb_italico);
        cb_riscado = (CheckBox) findViewById(R.id.cb_riscado);
        cb_alterado = (CheckBox) findViewById(R.id.cb_alterado);



        // Ao clicar no botão resgata o valor das variáveis e envia para sms
        btn_enviarWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                styleFont = new StyleFont();


                String mensagem = txt_mensagem.getText().toString();

                String mesagemComEstilo = mensagem;

                if (cb_negrito.isChecked() == true) {
                     mesagemComEstilo = styleFont.negrito(mensagem);
                }

                if (cb_italico.isChecked() == true) {
                     mesagemComEstilo = styleFont.italico(mensagem);
                }

                if (cb_riscado.isChecked() == true) {
                     mesagemComEstilo = styleFont.riscado(mensagem);
                }

                if (cb_alterado.isChecked() == true) {
                     mesagemComEstilo = styleFont.alterado(mensagem);
                }

                if (cb_negrito.isChecked() == true && cb_italico.isChecked() == true) {

                    mesagemComEstilo = styleFont.negrito(styleFont.italico(mensagem));
                }

                if (cb_negrito.isChecked() == true && cb_italico.isChecked() == true && cb_riscado.isChecked() == true) {

                    mesagemComEstilo = styleFont.negrito(styleFont.italico(styleFont.riscado(mensagem)));
                }

                if (cb_negrito.isChecked() == true && cb_italico.isChecked() == true && cb_riscado.isChecked() == true && cb_alterado.isChecked() == true) {

                    mesagemComEstilo = styleFont.negrito(styleFont.italico(styleFont.riscado(styleFont.alterado(mensagem))));
                }

                Intent i = new Intent ();

                i.setAction (Intent.ACTION_SEND);
                i.putExtra (Intent.EXTRA_TEXT, mesagemComEstilo);
                i.setType ("text/plain");
                i.setPackage ("com.whatsapp");

                startActivity (i);

            }
        });

        // Ao clicar no botão resgata o valor das variáveis e envia para sms
        btn_enviarSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String numero = txt_contato.getText().toString();
                String mensagem = txt_mensagem.getText().toString();

                Uri uri = Uri.parse("smsto:" + numero);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", mensagem);

                startActivity(intent);

            }
        });

    }


}
