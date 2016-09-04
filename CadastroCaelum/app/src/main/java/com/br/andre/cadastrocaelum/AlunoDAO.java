package com.br.andre.cadastrocaelum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

/**
 * Created by andre on 03/09/16.
 */
public class AlunoDAO extends SQLiteOpenHelper {

    //Nome e versão da Base de Dados
    private static final String DATABASE = "CadastroCaelum";
    private static final int VERSAO = 1;

    //Obrigatorio esse metodo
    public AlunoDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }


    public void salva(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("site", aluno.getSite());
        values.put("endereco", aluno.getEndereco());
        values.put("telefone", aluno.getTelefone());
        values.put("nota", aluno.getNota());
        values.put("foto", aluno.getFoto());


        getWritableDatabase().insert("Alunos", null, values);

    }

    public void onCreate(SQLiteDatabase db){

        String ddl = "CREATE TABLE Alunos (" +
                "id PRIMARY KEY, " +
                "nome TEXT UNIQUE NOT NULL," +
                "endereco TEXT, " +
                "telefone TEXT, " +
                "site TEXT, " +
                "foto TEXT, " +
                "nota REAL);";

        db.execSQL(ddl);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String ddl = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(ddl);
        this.onCreate(db);
    }

    public List<Aluno> getLista() {

        String[] colunas = {"id","nome","site","telefone", "endereco","foto", "nota"};
        Cursor cursor = getWritableDatabase().query("Alunos",colunas, null, null, null, null, null);

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        while (cursor.moveToNext() ) {

            Aluno aluno = new Aluno();

            aluno.setId(cursor.getLong(0)); //Id
            aluno.setNome(cursor.getString(1)); //Nome
            aluno.setSite(cursor.getString(2)); //Site
            aluno.setTelefone(cursor.getString(3)); // Telefone
            aluno.setEndereco(cursor.getString(4)); // Endereço
            aluno.setFoto(cursor.getString(5)); // Foto
            aluno.setNota(cursor.getDouble(6)); // Nota

            alunos.add(aluno);
        }


        return alunos;
    }

    public void deletar(Aluno aluno) {

       String[] args = {aluno.getId().toString};
       getWritableDatabase().delete("Alunos", "id=?", args);

    }
}
