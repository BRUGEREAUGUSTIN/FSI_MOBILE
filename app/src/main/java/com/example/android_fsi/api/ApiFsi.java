package com.example.android_fsi.api;

import com.example.android_fsi.classes.Etudiant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiFsi {


        @GET("etudiant")
        Call<ArrayList<Etudiant>> getAll();

        @GET("etudiant")
        Call<Etudiant> getById(@Query("id") int id);//EtudiantInfos

        @FormUrlEncoded
        @POST("EtudiantEndpoint.php")
        Call<RecupDataEtudiant> connection(
                @Field("login") String login,
                @Field("password") String mdp
        );



}
