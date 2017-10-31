package com.camilagiraldo.agenda;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.name;
import static com.camilagiraldo.agenda.R.id.libro;

public class SQliteActivity extends AppCompatActivity implements View.OnClickListener {

    TextView eidlibro, elibro, enombre, etelefono;
    Button beditar, beliminar;
    int cont;
    User user;
    String idlib, lib, nombre, telefono;

    Datos contactosSQLiteHelper;
    SQLiteDatabase dblibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sqlite);

        contactosSQLiteHelper = new Datos(this, "agendaBD", null, 1);
        dblibros = contactosSQLiteHelper.getWritableDatabase();

        eidlibro = (TextView) findViewById(R.id.tid);
        elibro = (TextView) findViewById(R.id.tlibro);
        enombre = (TextView) findViewById(R.id.tnombre);
        etelefono = (TextView) findViewById(R.id.ttelefono);

        beditar = (Button) findViewById(R.id.bregistrar);
        beliminar = (Button) findViewById(R.id.beliminar);

        beliminar.setOnClickListener(this);
        beditar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        idlib = eidlibro.getText().toString();
        lib=elibro.getText().toString();
        nombre=enombre.getText().toString();
        telefono=etelefono.getText().toString();
        ContentValues data = new ContentValues();
        switch (id) {
            case R.id.bregistrar:
                data.put("id", idlib);
                data.put("libro", lib);
                data.put("usuario", nombre);
                data.put("telefono", telefono);
                dblibros.insert("contactos", null, data);
                //clean();
                break;
            case R.id.beditar:
                data.put("libro",libro);
                data.put("usuario",nombre);
                data.put("telefono",telefono);
                dblibros.update("contactos",data, "nombre = '"+name+"'",null);
                clean();
                break;
            case R.id.beliminar:
                dblibros.delete("contactos","nombre = '"+name+"'",null);
                clean();
                break;
        }
    }

    private void clean() {
        eidlibro.setText("");
        elibro.setText("");
        enombre.setText("");
        etelefono.setText("");
    }
}
