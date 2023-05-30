package com.example.android_fsi.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_fsi.R;
import com.example.android_fsi.sqlLite.DatabaseManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class InfosActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private Context context1;
    DatabaseManager db= new DatabaseManager(this, database ,context1);
    HashMap<String,String> infoetu=new HashMap<String, String>();

    private BottomNavigationView navbar;
    private TextView nom;
    private TextView prenom;
    private TextView login;
    private TextView ville;
    private TextView nomRue;
    private TextView numRue;
    private TextView cp;
    private TextView tel;
    private TextView email;
    private TextView classe;
    private TextView specialite;
    private TextView mds;
    private TextView ent;
    private TextView prof;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infos);
        initialisation();



    }

    private void initialisation() {
        if(db.getInfosetudiant()!=null){
            infoetu=db.getInfosetudiant();}
        navbar = findViewById(R.id.navbarNote);
        navbar.setSelectedItemId(R.id.MesInfosMenu);
        nom=findViewById(R.id.textViewNom);
        prenom=findViewById(R.id.textViewPrenom);
        login=findViewById(R.id.textViewLogin);
        ville=findViewById(R.id.textViewVille);
        nomRue=findViewById(R.id.textViewRue);
        numRue=findViewById(R.id.textViewNumRue);
        cp=findViewById(R.id.textViewCp);
        tel=findViewById(R.id.textViewTel);
        email=findViewById(R.id.textViewEmail);
        classe=findViewById(R.id.textViewClasse);
        specialite=findViewById(R.id.textViewSpe);
        mds=findViewById(R.id.textViewMds);
        ent=findViewById(R.id.textViewEnt);
        prof=findViewById(R.id.textViewProf);
        navBarItemSelected();

        nom.setText(infoetu.get("nom"));
        prenom.setText(infoetu.get("prenom"));
        login.setText(infoetu.get("login"));
        ville.setText(infoetu.get("ville"));
        nomRue.setText(infoetu.get("rue"));
        numRue.setText(infoetu.get("cp"));
        cp.setText(infoetu.get("numeroRue"));
        tel.setText(infoetu.get("telephone"));
        email.setText(infoetu.get("email"));
        classe.setText(infoetu.get("classe"));
        specialite.setText(infoetu.get("specialite"));
        mds.setText(infoetu.get("Mds"));
        ent.setText(infoetu.get("entreprise"));
        prof.setText(infoetu.get("Professeur"));
    }

    private void navBarItemSelected() {
        navbar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case (R.id.MesInfosMenu):
                    Intent intent = new Intent(InfosActivity.this,
                            InfosActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent);
                    return true;
                case (R.id.AccueilMenu):
                    Intent intent2 = new Intent(InfosActivity.this,
                            AccueilActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent2);
                    return true;
                case (R.id.NotesMenu):
                    Intent intent3 = new Intent(InfosActivity.this,
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
