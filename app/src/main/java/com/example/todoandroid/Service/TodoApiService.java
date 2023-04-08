package com.example.todoandroid.Service;

import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Model.VerificationResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TodoApiService {
    @GET("TodoItem")
    Call<List<TodoItem>> getTodoItems();

    @POST("TodoItem/")
    Call<TodoItem> createTodoItem(@Body HashMap<String, Object> createTodoRequest);

    @GET("TodoItem/user/{userId}")
    Call<List<TodoItem>> getTodoItemsByUserId(@Path("userId")Integer id);

    @PUT("TodoItem/{id}/toggle-status")
    Call<TodoItem> updateTodoStatus(@Path("id")Integer id);

    @DELETE("TodoItem/{id}/")
    Call<Void> deleteTodoItem(@Path("id")Integer id);

    @POST("UserModel/signin")
    Call<VerificationResponse> signInUser(@Body HashMap<String, String> userCredentials);


}
