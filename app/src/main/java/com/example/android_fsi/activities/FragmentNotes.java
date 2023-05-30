package com.example.android_fsi.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android_fsi.R;
import com.example.android_fsi.sqlLite.DatabaseManager;

import java.util.HashMap;

public class FragmentNotes extends Fragment {

    private View view;
    private TextView date, noteEnt, noteDos,noteOral,com;
    private SQLiteDatabase database1;
    private Context context2;
    DatabaseManager db;
    HashMap<String,String> bilan1;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_freament_notes, container, false);
        date = view.findViewById(R.id.DateBilan1);
        noteEnt=view.findViewById(R.id.NoteEntBil1);
        noteDos=view.findViewById(R.id.NoteDosBilan2);
        noteOral=view.findViewById(R.id.NoteOraBilan2);
        com=view.findViewById(R.id.ComBilan2);
        db= new DatabaseManager(getContext(), database1 ,context2);
        bilan1=new HashMap<String, String>();
        bilan1=db.getBilan1();
        date.setText(bilan1.get("date"));
        noteEnt.setText(bilan1.get("entreprise"));
        noteDos.setText(bilan1.get("dossier"));
        noteOral.setText(bilan1.get("oral"));
        com.setText(bilan1.get("commentaire"));
        return view;


    }
}