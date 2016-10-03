package com.br.andre.smsregistro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

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

                    GravarEmArquivo salvar = new GravarEmArquivo(context);


                    //salvar.setNumero(telefone);
                   // salvar.setTexto(message);
                    //salvar.salvar();

                }


            }

        } catch (Exception e) {
            Log.e("SMSReceiver", "Exception smsReceiver" +e);
        }

    }

}
