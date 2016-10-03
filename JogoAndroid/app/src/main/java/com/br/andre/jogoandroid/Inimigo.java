package com.br.andre.jogoandroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Andre Riggs on 02/10/16.
 */

public class Inimigo extends Retangulo {

    public Inimigo(int x, int y) {
        super(x, y, 200,200);
    }

    public void mexe (int height, int width) {

        if (getY() < height) {
            setY(getY() + 5);
        } else {
            int x = (int) (Math.random() * (width - 50)); // cada quadrado sair em lugar diferente e acima da tela
            setX(x);
            setY(-25);
        }
    }

    // Desenha o inimigo
    public void draw (Canvas canvas, Paint paint) {
        paint.setColor(Color.GREEN);
        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setTextSize(40);
        paint2.setFakeBoldText(true);


        canvas.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), paint);
        canvas.drawText("_|_", getX() + 70, getY() + 100, paint2);

    }
}
