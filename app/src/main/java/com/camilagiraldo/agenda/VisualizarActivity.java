package com.camilagiraldo.agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class VisualizarActivity extends AppCompatActivity {


    private ArrayList<User> users;
    private RecyclerView recyclerlibros;
    Datos contactosSQLiteHelper;
    SQLiteDatabase dblibros;

    ArrayList<User> listadatos;
    RecyclerView recyclerView;

    //Datos conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_visualizar);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //ActionBar ab = getSupportActionBar();
        //ab.setDisplayHomeAsUpEnabled(true);
        //conn = new Datos (getApplicationContext(),"Agenda",null,1);

        users=new ArrayList<User>();
        contactosSQLiteHelper = new Datos(this, "agenda",null,1);
        dblibros = contactosSQLiteHelper.getWritableDatabase();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerlibros);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Cursor cursor = dblibros.rawQuery("SELECT * FROM contactos",null);

        if (cursor.moveToFirst()){
            do{
                User user = new User (String.valueOf(cursor.getInt(0)),
                        cursor.getString(1),
                        cursor.getString(3),
                        cursor.getString(2));
                users.add(user);
            }while (cursor.moveToNext());
        }

        Adaptador adapter = new Adaptador(this, users);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerlibros);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }
}
