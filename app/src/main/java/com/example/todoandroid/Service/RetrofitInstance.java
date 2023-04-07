package com.example.todoandroid.Service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//To follow singleton pattern
//One instance instantiation for all retrofit uses
public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://ead2api.azurewebsites.net/api/";


    //single pattern
    public static TodoApiService todoApiService(){

        //if not already created
        if(retrofit == null){

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        //if already created
        return retrofit.create(TodoApiService.class);
    }

}
