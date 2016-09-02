package com.br.andre.cadastrocaelum;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        final String[] nomes = {"Ana", "Jose", "Felipe"};

        int layout = android.R.layout.simple_list_item_1;

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, layout, nomes);

        ListView lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(adapter);

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

                Toast.makeText(ListaAlunos.this,
                        "Clique longo na posição " + adapter.getItemAtPosition(posicao), Toast.LENGTH_LONG).show();

                //Quando fazemos o clique longo desejamos consumir o evento (TRUE) ou deixar também o clique curto?(FALSE)
                //Por default é false.
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.listagem_alunos,menu);

        return super.onCreateOptionsMenu(menu);
    }
}

