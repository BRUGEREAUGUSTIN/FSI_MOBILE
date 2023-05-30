package com.example.android_fsi.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android_fsi.R;
import com.example.android_fsi.sqlLite.DatabaseManager;

import java.util.HashMap;

public class FragmentNotes2 extends Fragment {
    private View view;
    private TextView date, noteDos, noteOral,com;
    private SQLiteDatabase database1;
    private Context context2;
    DatabaseManager db;
    HashMap<String,String> bilan2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_freament_notes2, container, false);
        date = view.findViewById(R.id.dateBilan2);
        noteDos = view.findViewById(R.id.NoteDosBilan2);
        noteOral = view.findViewById(R.id.NoteOraBilan2);
        com=view.findViewById(R.id.ComBilan2);
        db= new DatabaseManager(getContext(), database1 ,context2);
        bilan2=new HashMap<String, String>();
        bilan2=db.getBilan2();
        date.setText(bilan2.get("date"));
        noteDos.setText(bilan2.get("dossier"));
        noteOral.setText(bilan2.get("oral"));
        com.setText(bilan2.get("commentaire"));
        return view;
    }

    public void initialisation() {

    }
}
