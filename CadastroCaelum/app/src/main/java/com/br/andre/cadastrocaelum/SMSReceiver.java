package com.br.andre.cadastrocaelum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by andre on 08/09/16.
 */
public class SMSReceiver extends BroadcastReceiver {

    public SMSReceiver() {
    }


    @Override
    public void onReceive(Context context, Intent intent) {



        final Bundle bundle = intent.getExtras();

        try {



            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage smsAtual = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String telefone = smsAtual.getDisplayOriginatingAddress();

                    String quemEnviou = telefone;
                    String message = smsAtual.getDisplayMessageBody();

                    AlunoDAO dao = new AlunoDAO(context);

                    boolean ehAluno = dao.isAluno(telefone);

                    dao.close();

                    if (ehAluno){
                        //MediaPlayer player = MediaPlayer.create(context,R.raw.mclon);
                        // player.start();
                        Toast.makeText(context, "Tocando música...",Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(context, "Sem música...",Toast.LENGTH_LONG).show();


                    GravarEmArquivo salvar = new GravarEmArquivo();

                    salvar.getNumero(telefone);
                    salvar.getTexto(message);
                    salvar.salvar();

                }


            }

        } catch (Exception e) {
            Log.e("SMSReceiver", "Exception smsReceiver" +e);
        }

    }

}

