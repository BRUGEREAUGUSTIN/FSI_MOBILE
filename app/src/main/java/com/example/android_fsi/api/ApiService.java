package com.example.android_fsi.api;
import com.example.android_fsi.api.ApiFsi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiService {
    private static final String url = "http://192.168.56.11/fsi-php/src/view/api/";
    private static ApiService apiService;
    private static Retrofit retrofit;

    ApiService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiService getInstance(){
        if (apiService == null){
            apiService = new ApiService();
        }
        return apiService;
    }

    public ApiFsi getApiFsi(){
        return retrofit.create(ApiFsi.class);
    }
}
