package com.example.todoandroid.Service;

import com.example.todoandroid.Model.TodoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoApiService {
    @GET("TodoItem")
    Call<List<TodoItem>> getTodoItems();
}
