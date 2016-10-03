package com.br.andre.cadastrocaelum;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.br.andre.cadastrocaelum.adapter.ListaAlunosAdapter;

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
                // Toast.makeText(ListaAlunos.this, "Clique na posição " + posicao,Toast.LENGTH_LONG ).show();

                Aluno alunoClicado = (Aluno) adapter.getItemAtPosition(posicao);

                // É uma Intent que faz chegar na activity
                Intent irParaFormulario = new Intent(ListaAlunos.this, Formulario.class);

                /*  Precisamos levar os dados de uma activity para outra no caso é necessário
                    serializar a classe aluno para o objeto também ser serializado.
                    Isso porque cada aplicação usa uma máquina virtual individualizada.

                    Levar aluno para o formulário.
                */
                irParaFormulario.putExtra("alunoSelecionado", alunoClicado);

                startActivity(irParaFormulario);
            }
        });

        //Clique longo no Item
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {

                /*  Deixa o texto selecionado vermelho
                    TextView txt = (TextView) view;
                    txt.setTextColor(Color.RED);
                */

                aluno = (Aluno) adapter.getItemAtPosition(posicao);

                return false;
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Cria uma Intent implícita, chama qualquer activity que sabe fazer ligação
                Intent irParaTelaDeDiscagem = new Intent(Intent.ACTION_CALL);
                Uri discarPara = Uri.parse("tel:" + aluno.getTelefone());
                irParaTelaDeDiscagem.setData(discarPara);

                if (ActivityCompat.checkSelfPermission(ListaAlunos.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    Toast.makeText(ListaAlunos.this, "Você não tem permissão para fazer ligações!, ALTERE AS PERMISSÕES em seu aparelho.",Toast.LENGTH_LONG ).show();
                    return false;
                }
                startActivity(irParaTelaDeDiscagem);
                return false;
            }
        });

        menu.add("Enviar SMS");

        MenuItem site = menu.add("Navegar no site");
        site.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //Cria uma Intent implícita
                Intent irParaOSite = new Intent(Intent.ACTION_VIEW);

                Uri localSite = Uri.parse("http://"+ aluno.getSite());
                irParaOSite.setData(localSite);

                startActivity(irParaOSite);

                return false;
            }
        });

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




        // Mostrar o array de Alunos em forma de layout nesta contentView
        ListaAlunosAdapter adapter = new ListaAlunosAdapter(alunos, this);
        LayoutInflater inflater = getLayoutInflater();

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


