package com.example.android_fsi.sqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android_fsi.api.RecupDataEtudiant;
import com.example.android_fsi.classes.Bilan1;
import com.example.android_fsi.classes.Bilan2;
import com.example.android_fsi.classes.Notes;
import com.example.android_fsi.classes.Professeur;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "fsi_sqlite.db";

    public static final String TABLE_ETU = "etudiant",
            COLUMN_ID = "id",
            COLUMN_PRE_ETU = "prenom",
            COLUMN_NOM_ETU = "nom",
            COLUMN_LOG_ETU = "login",
            COLUMN_VIL_ETU = "ville",
            COLUMN_RUE_ETU = "rue",
            COLUMN_CP_ETU = "cp",
            COLUMN_NUM_RUE_ETU = "numeroRue",
            COLUMN_TEL_ETU = "telephone",
            COLUMN_EMA_ETU = "email",
            COLUMN_CLAS_ETU = "classe",
            COLUMN_SPE_ETU = "specialite",
            COLUMN_ENT_ETU = "entreprise",
            COLUMN_PRO_ETU = "Professeur",
            COLUMN_MDS_ETU = "Mds",
            COLUMN_ORA_1_ETU = "noteOral1",
            COLUMN_DOS_1_ETU = "noteDos1",
            COLUMN_ENT_1_ETU = "noteEnt1",
            COLUMN_DAT_1_ETU = "Date1",
            COLUMN_COM_1_ETU = "Com1",
            COLUMN_ORA_2_ETU = "noteOral2",
            COLUMN_DOS_2_ETU = "noteDos2",
            COLUMN_DAT_2_ETU = "Date2",
            COLUMN_COM_2_ETU = "Com2";

    private static final String CREATE_TABLE_ETUDIANT = "CREATE TABLE " + TABLE_ETU +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NOM_ETU + " TEXT, " +
            COLUMN_PRE_ETU + " TEXT, " +
            COLUMN_LOG_ETU + " TEXT, " +
            COLUMN_VIL_ETU + " TEXT, " +
            COLUMN_RUE_ETU + " INTEGER, " +
            COLUMN_CP_ETU + " TEXT, " +
            COLUMN_NUM_RUE_ETU + " TEXT, " +
            COLUMN_TEL_ETU + " TEXT, " +
            COLUMN_EMA_ETU + " TEXT, " +
            COLUMN_CLAS_ETU+ " TEXT, " +
            COLUMN_SPE_ETU + " TEXT, " +
            COLUMN_ENT_ETU + " TEXT, " +
            COLUMN_PRO_ETU + " TEXT, " +
            COLUMN_MDS_ETU + " TEXT, " +
            COLUMN_ORA_1_ETU + " FLOAT, " +
            COLUMN_DOS_1_ETU + " FLOAT, " +
            COLUMN_ENT_1_ETU + " FLOAT, " +
            COLUMN_DAT_1_ETU + " TEXT, " +
            COLUMN_COM_1_ETU + " TEXT, " +
            COLUMN_ORA_2_ETU + " FLOAT, " +
            COLUMN_DOS_2_ETU + " FLOAT, " +
            COLUMN_DAT_2_ETU + " FLOAT," +
            COLUMN_COM_2_ETU + " TEXT );"
            ;


    public DatabaseManager(Context context, SQLiteDatabase database, Context context1) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ETUDIANT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETU+";");
        onCreate(db);
    }

    public void delete(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETU+";");
        onCreate(db);

    }

    public Boolean insertData(RecupDataEtudiant monEtudiant) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Integer id = monEtudiant.getEtudiant().getId();
        contentValues.put(COLUMN_ID, id != null ? id : null);
        contentValues.put(COLUMN_NOM_ETU, monEtudiant.getEtudiant().getNom());
        contentValues.put(COLUMN_PRE_ETU, monEtudiant.getEtudiant().getPrenom());
        contentValues.put(COLUMN_LOG_ETU, monEtudiant.getEtudiant().getLogin());
        contentValues.put(COLUMN_VIL_ETU, monEtudiant.getEtudiant().getVille());
        contentValues.put(COLUMN_RUE_ETU, monEtudiant.getEtudiant().getRue());
        contentValues.put(COLUMN_CP_ETU, monEtudiant.getEtudiant().getCp());
        contentValues.put(COLUMN_NUM_RUE_ETU, monEtudiant.getEtudiant().getNumeroRue());
        contentValues.put(COLUMN_TEL_ETU, monEtudiant.getEtudiant().getTelephone());
        contentValues.put(COLUMN_EMA_ETU, monEtudiant.getEtudiant().getEmail());
        contentValues.put(COLUMN_CLAS_ETU, monEtudiant.getEtudiant().getClasse().getLibelle());
        contentValues.put(COLUMN_SPE_ETU, monEtudiant.getEtudiant().getSpecialite().getLibelle());
        contentValues.put(COLUMN_ENT_ETU, monEtudiant.getEtudiant().getEntreprise().getLibelle());
        String proEtudiant = null;
        Professeur professeur = monEtudiant.getEtudiant().getProfesseur();
        if (professeur != null) {
            proEtudiant = monEtudiant.getEtudiant().getProfesseur().getNom();
        }
        contentValues.put(COLUMN_PRO_ETU, proEtudiant);
        contentValues.put(COLUMN_MDS_ETU, monEtudiant.getEtudiant().getMds().getNom()+" "+monEtudiant.getEtudiant().getMds().getPrenom());
        Float b1ora = null;
        Notes notes = monEtudiant.getNotes();
        if (notes != null) {
            Bilan1 bilan1 = notes.getBilan1();
            if (bilan1 != null && Float.valueOf(bilan1.getNoteOral()) != null) {
                b1ora = bilan1.getNoteOral();
            }
        }
        contentValues.put(COLUMN_ORA_1_ETU, b1ora);
        Float b1ent = null;
        Notes notes2 = monEtudiant.getNotes();
        if (notes2 != null) {
            Bilan1 bilan1 = notes.getBilan1();
            if (bilan1 != null && Float.valueOf(bilan1.getNoteEntreprise()) != null) {
                b1ent = bilan1.getNoteEntreprise();
            }
        }
        contentValues.put(COLUMN_ENT_1_ETU, b1ent);
        Float b1Dos = null;
        Notes notesDos1 = monEtudiant.getNotes();
        if (notesDos1 != null) {
            Bilan1 bilan1 = notes.getBilan1();
            if (bilan1 != null && Float.valueOf(bilan1.getNoteDossier()) != null) {
                b1Dos = bilan1.getNoteDossier();
            }
        }
        contentValues.put(COLUMN_DOS_1_ETU, b1Dos);
        String b1date = null;
        Notes notes3 = monEtudiant.getNotes();
        if (notes3 != null) {
            Bilan1 bilan1 = notes3.getBilan1();
            if (bilan1 != null && bilan1.getDate() != null) {
                b1date = bilan1.getDate();
            }
        }
        contentValues.put(COLUMN_DAT_1_ETU, b1date != null ? b1date : null);
        String b1com = null;
        Notes note4 = monEtudiant.getNotes();
        if (note4 != null) {
            Bilan1 bilan1 = note4.getBilan1();
            if (bilan1 != null) {
                b1com = bilan1.getCommentaire();
            }
        }
        contentValues.put(COLUMN_COM_1_ETU, b1com);
        Float b2ora = null;
        Notes note5 = monEtudiant.getNotes();
        if (note5 != null) {
            Bilan2 bilan2 = note5.getBilan2();
            if (bilan2 != null && Float.valueOf(bilan2.getNoteOral()) != null) {
                b2ora = Float.valueOf(bilan2.getNoteOral());
            }
        }
        contentValues.put(COLUMN_ORA_2_ETU, b2ora != null ? b2ora : null);
        Float b2dos = null;
        Notes note6 = monEtudiant.getNotes();
        if (note6 != null) {
            Bilan2 bilan2 = note6.getBilan2();
            if (bilan2 != null && Float.valueOf(bilan2.getNoteDossier()) != null) {
                b2dos = Float.valueOf(bilan2.getNoteDossier());
            }
        }
        contentValues.put(COLUMN_DOS_2_ETU, b2dos);
        String b2com = null;
        Notes note7 = monEtudiant.getNotes();
        if (note7 != null) {
            Bilan2 bilan2 = note7.getBilan2();
            if (bilan2 != null) {
                b2com = bilan2.getCommentaire();
            }
        }
        contentValues.put(COLUMN_COM_2_ETU, b2com);
        String b2date = null;
        Notes note8 = monEtudiant.getNotes();
        if (note8 != null) {
            Bilan2 bilan2 = note8.getBilan2();
            if (bilan2 != null && bilan2.getDate() != null) {
                b2date = bilan2.getDate();
            }
        }
        contentValues.put(COLUMN_DAT_2_ETU, b2date != null ? b2date : null);

        long result = db.insert( TABLE_ETU,  null, contentValues);
        if (result ==1) return false;
        else
            return true;
    }
    public HashMap<String, String> getInfosetudiant() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT nom, prenom, login, ville, rue, cp, numeroRue, telephone, email, classe, specialite, entreprise, Professeur,Mds FROM etudiant", null);
        HashMap<String, String> infosEtudiant = new HashMap<>();

        while(cursor.moveToNext()) {

            infosEtudiant.put("nom", cursor.getString(0));
            infosEtudiant.put("prenom", cursor.getString(1));
            infosEtudiant.put("login", cursor.getString(2));
            infosEtudiant.put("ville", cursor.getString(3));
            infosEtudiant.put("rue", cursor.getString(4));
            infosEtudiant.put("cp", cursor.getString(5));
            infosEtudiant.put("numeroRue", cursor.getString(6));
            infosEtudiant.put("telephone", cursor.getString(7));
            infosEtudiant.put("email", cursor.getString(8));
            infosEtudiant.put("classe", cursor.getString(9));
            infosEtudiant.put("specialite", cursor.getString(10));
            infosEtudiant.put("entreprise", cursor.getString(11));
            infosEtudiant.put("Professeur", cursor.getString(12));
            infosEtudiant.put("Mds", cursor.getString(13));

        }

        cursor.close();
        db.close();

        return infosEtudiant;
    }
    public HashMap<String, String> getBilan1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT noteOral1, noteDos1,noteEnt1,Date1,Com1 FROM etudiant", null);
        HashMap<String, String> infosEtudiant = new HashMap<>();

        while(cursor.moveToNext()) {

            infosEtudiant.put("oral", cursor.getString(0));
            infosEtudiant.put("dossier", cursor.getString(1));
            infosEtudiant.put("entreprise", cursor.getString(2));
            infosEtudiant.put("date", cursor.getString(3));
            infosEtudiant.put("commentaire", cursor.getString(4));


        }

        cursor.close();
        db.close();

        return infosEtudiant;
    }
    public HashMap<String, String> getBilan2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT noteOral2, noteDos2,Date2,Com2 FROM etudiant", null);
        HashMap<String, String> infosEtudiant = new HashMap<>();

        while(cursor.moveToNext()) {

            infosEtudiant.put("oral", cursor.getString(0));
            infosEtudiant.put("dossier", cursor.getString(1));
            infosEtudiant.put("date", cursor.getString(2));
            infosEtudiant.put("commentaire", cursor.getString(3));


        }

        cursor.close();
        db.close();

        return infosEtudiant;
    }
    public HashMap<String, String> getAcceuilInfos() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT nom, prenom, classe FROM etudiant", null);
        HashMap<String, String> infosEtudiant = new HashMap<>();

        while(cursor.moveToNext()) {

            infosEtudiant.put("nomPrenom", cursor.getString(0)+"  "+cursor.getString(1));
            infosEtudiant.put("classe", cursor.getString(2));



        }

        cursor.close();
        db.close();

        return infosEtudiant;
    }

}
