package com.example.android_fsi.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_fsi.R;
import com.example.android_fsi.api.RecupDataEtudiant;
import com.example.android_fsi.sqlLite.DatabaseManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class AccueilActivity extends AppCompatActivity {

    private BottomNavigationView navbar;
    private TextView nom, classe;
    private Button info, note, deco;
    private SQLiteDatabase database1;
    private Context context2;
    DatabaseManager db;
    HashMap<String,String> infos;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        initialisation();

    }

    public void initialisation() {
        nom=findViewById(R.id.textViewNom);
        classe=findViewById(R.id.textViewClasse);

        info=findViewById(R.id.buttonVoirInfo);
        note=findViewById(R.id.buttonConsulterNotes);
        deco=findViewById(R.id.buttonDeconnexion);
        navbar=findViewById(R.id.bottomNavigationViewAccueil);
        navbar.setSelectedItemId(R.id.AccueilMenu);
        db= new DatabaseManager(this, database1 ,context2);
        infos=db.getAcceuilInfos();
        classe.setText(infos.get("classe"));
        nom.setText(infos.get("nomPrenom"));
        navBarItemSelected();
        deco.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this,
                    MainActivity.class);
            db.delete();
            startActivity(intent);
        });
        info.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this,
                    InfosActivity.class);
            startActivity(intent);
        });
        note.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this,
                    NoteActivity.class);
            startActivity(intent);
        });
    }


    private void navBarItemSelected(){
        navbar.setOnItemSelectedListener(item ->{
            switch (item.getItemId()) {
                case (R.id.MesInfosMenu):
                    Intent intent = new Intent(AccueilActivity.this,
                            InfosActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent);
                    return true;
                case (R.id.AccueilMenu):
                    Intent intent2 = new Intent(AccueilActivity.this,
                            AccueilActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent2);
                    return true;
                case (R.id.NotesMenu):
                    Intent intent3 = new Intent(AccueilActivity.this,
                            NoteActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent3);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        });
    }

}
