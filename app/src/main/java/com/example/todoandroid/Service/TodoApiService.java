package com.example.todoandroid.Service;

import android.content.Intent;

import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Model.VerificationResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TodoApiService {
    @GET("TodoItem")
    Call<List<TodoItem>> getTodoItems();

    @GET("TodoItem/user/{userId}")
    Call<List<TodoItem>> getTodoItemsByUserId(@Path("userId")Integer id);

    @POST("UserModel/signin")
    Call<VerificationResponse> signInUser(@Body HashMap<String, String> userCredentials);
}
