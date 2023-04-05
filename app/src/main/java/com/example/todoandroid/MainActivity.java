package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.todoandroid.Adapter.TodoAdapter;
import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Service.TodoApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Create a Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ead2api.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create a service instance
        TodoApiService service = retrofit.create(TodoApiService.class);

        // Call the API endpoint
        Call<List<TodoItem>> call = service.getTodoItems();
        call.enqueue(new Callback<List<TodoItem>>() {
            @Override
            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {
                if (response.isSuccessful()) {
                    List<TodoItem> todoItems = response.body();
                    adapter = new TodoAdapter(todoItems);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get todo items", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<TodoItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get todo items", Toast.LENGTH_SHORT).show();
            }
        });
    }
}