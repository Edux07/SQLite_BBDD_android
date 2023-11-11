package com.example.sqlite_acd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public EditText eTT1, eTT2, eTT3;
    BBDD gestor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTT1=findViewById(R.id.eTT1);
        eTT2=findViewById(R.id.eTT2);
        eTT3=findViewById(R.id.eTT3);
        gestor= new BBDD(this, "bdPolitica", null, 1);
    }
    public void presion(View view){
        SQLiteDatabase bd= gestor.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("NOMBRE", eTT1.getText().toString());
        registro.put("EDAD", eTT2.getText().toString());
        registro.put("ESTUDIOS", eTT3.getText().toString());
        bd.insert("LIDERESPOLITICOS", null, registro);
        bd.close();
        Toast.makeText(this, "Insertado", Toast.LENGTH_SHORT).show();
    }
    public void presion2(View view){
        SQLiteDatabase bd= gestor.getWritableDatabase();
        String [] aux ={eTT1.getText().toString()};
        Cursor fila = bd.query("LIDERESPOLITICOS", null, "NOMBRE = ?", aux, null, null, null);
        if(fila.moveToFirst()){
            eTT1.setText(fila.getString(1));
            eTT2.setText(fila.getString(2));
            eTT3.setText(fila.getString(3));
        }else Toast.makeText(this, "No se ha encontrado al lider", Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void presion3(View view){
        SQLiteDatabase bd= gestor.getWritableDatabase();
        int filasborradas = bd.delete("LIDERESPOLITICOS", "NOMBRE = ' " + eTT1.getText().toString() + "'", null);
        if(filasborradas==1) Toast.makeText(this, "Sd ha borrado el lider politico " + eTT1.getText().toString(), Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Sd ha modificado el lider politico " + eTT1.getText().toString(), Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void presion4(View view){
        SQLiteDatabase bd= gestor.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("EDAD", Integer.parseInt(eTT2.getText().toString()));
        registro.put("ESTUDIOS", Integer.parseInt(eTT3.getText().toString()));
        int filasUpdate = bd.update("LIDERESPOLITICOS", registro, "NOMBRE ='"+ eTT1.getText() + "'", null);
        if(filasUpdate==1) Toast.makeText(this, "Sd ha modificado el lider politico " + eTT1.getText().toString(), Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "El lider politico"+ eTT1.getText().toString() + "No se encuentra en la BBDD", Toast.LENGTH_SHORT).show();
        bd.close();
    }





}