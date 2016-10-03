package com.br.andre.cadastrocaelum.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.andre.cadastrocaelum.Aluno;
import com.br.andre.cadastrocaelum.R;

import java.util.List;

/**
 * Created by andre on 01/10/16.
 */
public class ListaAlunosAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Activity activity;

    public ListaAlunosAdapter(List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        Aluno aluno = alunos.get(i);

        return aluno.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Aluno aluno = alunos.get(i);
        LayoutInflater inflater = activity.getLayoutInflater();

        View linha = inflater.inflate(R.layout.linha_listagem, null);

        TextView nome = (TextView) linha.findViewById(R.id.nome);
        nome.setText(aluno.getNome());

        ImageView foto = (ImageView) linha.findViewById(R.id.foto);

        //Verifica se o aluno tem foto, caso não deixa imagem padrão sem foto
        if(aluno.getFoto() != null) {

            Bitmap fotoAluno = BitmapFactory.decodeFile(aluno.getFoto());
            Bitmap fotoReduzida = Bitmap.createScaledBitmap(fotoAluno, 100, 100, true);

            foto.setImageBitmap(fotoReduzida);
        } else {
            // Acessar diretamente a pasta drawable para pegar a noImage.png
            Drawable semFoto = activity.getResources().getDrawable(R.drawable.no_image);
            foto.setImageDrawable(semFoto);
        }

        return linha;
    }
}
