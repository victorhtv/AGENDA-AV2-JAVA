package com.br.andre.cadastrocaelum;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ListaAlunos extends AppCompatActivity {

    private ListView lista;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        //No onCreate ele já mostra a lista
        lista = (ListView) findViewById(R.id.lista);
        registerForContextMenu(lista);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {

                Toast.makeText(ListaAlunos.this, "Clique na posição " + posicao,Toast.LENGTH_LONG ).show();
            }
        });

        //Clique longo no Item
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {

                //Deixa o texto selecionado vermelho
                TextView txt = (TextView) view;
                txt.setTextColor(Color.RED);

                aluno = (Aluno) adapter.getItemAtPosition(posicao);

                return false;
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        menu.add("Ligar");
        menu.add("Enviar SMS");
        menu.add("Navegar no site");

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlunoDAO dao = new AlunoDAO(ListaAlunos.this);

                dao.deletar(aluno);
                dao.close();

                carregaLista();

                return false;
            }
        });

        menu.add("Ver no mapa");
        menu.add("Enviar e-mail");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    protected void onResume(){
        super.onResume();

       carregaLista();

    }

    private void carregaLista(){

        //Instacia o BD
        AlunoDAO dao = new AlunoDAO(this);

        // Gera a lista de alunos
        List<Aluno> alunos = dao.getLista();
        dao.close();


        int layout = android.R.layout.simple_list_item_1;

        // Mostrar o array de Alunos em forma de layout nesta contentView
        ArrayAdapter <Aluno> adapter = new ArrayAdapter<Aluno>(this, layout, alunos);

        // cria um objeto listView do id da lista
        lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(adapter); //coloca o adapter nela
    }

    //Metodo do menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listagem_alunos,menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Ao clicar no icone de Menu
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemClicado = item.getItemId();
        String itemNome = item.getTitle().toString(); // Pega o nome do Titulo do menu

        switch (itemClicado) {
            // Item novo
            case R.id.novo:
                Intent irParaFormulario = new Intent(this, Formulario.class);
                startActivity(irParaFormulario);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item)
;        }
    }


