package com.example.android_fsi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_fsi.R;
import com.example.android_fsi.api.ApiFsi;
import com.example.android_fsi.api.ApiService;
import com.example.android_fsi.api.RecupDataEtudiant;
import com.example.android_fsi.sqlLite.DatabaseManager;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private Context context1;
    DatabaseManager db= new DatabaseManager(this, database ,context1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisation();
    }

    public void initialisation() {
        EditText login = findViewById(R.id.LoginConnexion);
        EditText mdp = findViewById(R.id.MdpConnexion);
        Button connexion = findViewById(R.id.BoutonConnexion);
        TextView error = findViewById(R.id.ErreurConnexion);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setText(null);
                error.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                if (!login.getText().toString().isEmpty() && !mdp.getText().toString().isEmpty()) {
                    Call<RecupDataEtudiant> call = ApiService.getInstance().getApiFsi().connection(login.getText().toString(), mdp.getText().toString());
                    call.enqueue(new Callback<RecupDataEtudiant>() {
                        @Override
                        public void onResponse(Call<RecupDataEtudiant> call, Response<RecupDataEtudiant> response) {
                            if (response.isSuccessful()) {
                                System.out.println(response.body().toString());
                                RecupDataEtudiant monEtudiant = response.body();
                                if(monEtudiant.getEtudiant()!=null) {
                                    db.delete();
                                    db.insertData(monEtudiant);
                                    Intent intent = new Intent(MainActivity.this,
                                            AccueilActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Log.e("Monetudiant_ERROR", "Error code: " + response.code() + ", message:" + response.message());
                                    error.setText(R.string.erreurConnexion);
                                    error.setCompoundDrawablesWithIntrinsicBounds(getDrawable(R.drawable.ic_baseline_warning_amber_24), null, null, null);

                                }
                            } else {
                                Log.e("API_ERROR", "Error code: " + response.code() + ", message:" + response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<RecupDataEtudiant> call, Throwable t) {
                            Log.e("API_FAILURE", "Error code:" + t.getMessage(), t);
                            error.setText(R.string.erreurConnexion);
                            error.setCompoundDrawablesWithIntrinsicBounds(getDrawable(R.drawable.ic_baseline_warning_amber_24), null, null, null);

                        }
                    });

                } else {
                    error.setText("erreur vide");
                    error.setCompoundDrawablesWithIntrinsicBounds(getDrawable(R.drawable.ic_baseline_warning_amber_24), null, null, null);
                }

            }
        });
        //REINITIALISATION DU MDP
        /*mdpForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ReintialisationMdpActivity.class);
                startActivity(intent);
            }
        });*/
    }

    private boolean veriLogins(String login, String mdp) {
        return Objects.equals(login, "") && Objects.equals(mdp, "");
    }

}