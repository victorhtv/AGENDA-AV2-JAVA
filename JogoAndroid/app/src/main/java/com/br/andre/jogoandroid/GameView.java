package com.br.andre.jogoandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andre Riggs on 02/10/16.
 */

public class GameView extends View implements Runnable{

    private static final int INTERVAL = 10; // pausa velocidade de 10 milisegundos
    private boolean running = true; // para enquanto nosso jogo está executando, false para parar de executar
    private int y; //
    private Paint paint; // desenhar
    private Inimigo[] inimigos;

    public GameView(Context context) {
        super(context);

        paint = new Paint();
        Thread minhaThread = new Thread(this); // Executa tarefas em segundo plano
        minhaThread.setPriority(Thread.MIN_PRIORITY);
        minhaThread.start();

    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(INTERVAL);

            } catch (Exception e) {
                Log.e("Erro", e.getMessage());
            }

            update();
        }
    }

    private void update() {

        if (inimigos == null) {
            return;
        }


        for (int i = 0; i < inimigos.length; i++) {
            inimigos[i].mexe(getWidth(), getHeight());
        }

        // Dispara o método draw (para desenhar)
        postInvalidate();
    }

    // Método para desenhar
    public void draw (Canvas canvas) {
        super.draw(canvas);

        if (inimigos == null) {
            iniciaJogo();
        }
        canvas.drawColor(Color.GRAY); //pode ser qualquer cor ou figura

        for (int i = 0; i < inimigos.length; i++){
            inimigos[i].draw(canvas,paint);
        }
    }

    // Método para dizer que o programa acabou, para o jogo, se não tiver o jogo continua em background
    public void release() {
        running = false;
    }

    public void iniciaJogo() {

        inimigos = new Inimigo[3];  // Quantidade de Inimigos
       // inimigos = new Inimigo[getHeight() / 10];

        //Log.e("Qtd Retangulos: ", valor);


        for (int i = 0; i < inimigos.length; i++) {

            //Descobre a posição do inimigo
            int x = (int) (Math.random() * (getWidth() + 25));
            int y = i * - 200; // Distancia de cada quadrado de lado
            inimigos[i] = new Inimigo(x,y);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            int x = (int) event.getX();
            int y = (int) event.getY();

            for (int i = 0; i < inimigos.length; i++) {

                if (inimigos[i].colide(x,y)) {
                    inimigos[i].setX(-300); // Se tocar no inimigo ele vai para fora da tela

                }
            }
        }

    return  super.onTouchEvent(event);
    }
}
