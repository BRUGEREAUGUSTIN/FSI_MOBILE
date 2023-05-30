package com.example.android_fsi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_fsi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NoteActivity  extends AppCompatActivity {

    private TextView BtnBilan1, BtnBilan2;
    private FrameLayout frameLayout;
    private View barreBilan1, barreBilan2;
    private BottomNavigationView navbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        initialisation();
    }

    private void initialisation() {
        navbar = findViewById(R.id.bottomNavigationView);
        navbar.setSelectedItemId(R.id.NotesMenu);
        navBarItemSelected();
        BtnBilan1= findViewById(R.id.BoutonBilan1);
        BtnBilan2= findViewById(R.id.BoutonBilan2);
        frameLayout= findViewById(R.id.frame_notes);
        barreBilan1= findViewById(R.id.subtitleBilan1);
        barreBilan2= findViewById(R.id.subtitleBilan2);
        replaceFragment(new FragmentNotes());
        barreBilan2.setBackgroundResource(R.color.colorPrimary);

    BtnBilan1.setOnClickListener(v->{
        replaceFragment(new FragmentNotes());
        barreBilan1.setBackgroundResource(R.color.white);
        barreBilan2.setBackgroundResource(R.color.colorPrimary);

    });
        BtnBilan2.setOnClickListener(v->{
            replaceFragment(new FragmentNotes2());
            barreBilan1.setBackgroundResource(R.color.colorPrimary);
            barreBilan2.setBackgroundResource(R.color.white);

        });
    }
    private void replaceFragment(Fragment frag){
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.frame_notes, frag);
        fragTrans.commit();
    }

    private void navBarItemSelected() {
        navbar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case (R.id.MesInfosMenu):
                    Intent intent = new Intent(NoteActivity.this,
                            InfosActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent);
                    return true;
                case (R.id.AccueilMenu):
                    Intent intent2 = new Intent(NoteActivity.this,
                            AccueilActivity.class);
                    /*intent.putExtra("MesArticles", mesArticles);*/
                    startActivity(intent2);
                    return true;
                case (R.id.NotesMenu):
                    Intent intent3 = new Intent(NoteActivity.this,
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
