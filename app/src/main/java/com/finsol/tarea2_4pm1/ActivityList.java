package com.finsol.tarea2_4pm1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity
{
    ListView listautos;
    List<Imagenes> AutosList;
    ArrayList<String> autoLista;
    private static CustomAdapter adaptercustom;
    SQLiteConexion conexion;
    ArrayList<Imagenes> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listautos = (ListView) findViewById(R.id.ListAutos);
        AutosList = new ArrayList<>();

        autoLista = new ArrayList<String>();
        GetListImagenes();

        listautos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String id = lista.get(i).getImage();
                Intent intent = new Intent(ActivityList.this, firma.class);
                intent.putExtra("firma",lista.get(i).getImage());
                startActivity(intent);
                Toast.makeText(ActivityList.this, "Cargando Firma... ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void GetListImagenes() {
        SQLiteDatabase db = conexion.getReadableDatabase(); //Base de Datos en modo lectura
        Imagenes listImagenes;

        lista = new ArrayList<>(); //lista de objetos del tipo Personas
        Cursor cursor = db.rawQuery( Transacciones.GetImagenes ,null);

        while (cursor.moveToNext()){
            listImagenes = new Imagenes();
            listImagenes.setId(cursor.getInt(0));
            listImagenes.setDescripcion(cursor.getString(1));
            listImagenes.setImage(cursor.getString(2));

            lista.add(listImagenes);
        }
        cursor.close();

        adaptercustom = new CustomAdapter(lista, getApplicationContext());

        // ArrayAdapter adp = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, autoLista);
        listautos.setAdapter(adaptercustom);
    }

}