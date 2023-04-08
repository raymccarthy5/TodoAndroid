package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.todoandroid.Adapter.TodoAdapter;
import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Service.RetrofitInstance;
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

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer userId = getIntent().getIntExtra("userId", 0);

        Log.i("User Id", "id" +userId);

        //Init with userId
        this.initToDoView(userId);

    }

    public void updateCheck(View view){

        //Each checbox Id stored in text string
        //converted to integer
        checkBox = (CheckBox) view;
        Integer formattedId = Integer.parseInt(checkBox.getText().toString());

        TodoApiService service = RetrofitInstance.todoApiService();

        // Call the API endpoint
        Call<TodoItem> call = service.updateTodoStatus(formattedId);

        call.enqueue(new Callback<TodoItem>() {
            @Override
            public void onResponse(Call<TodoItem> call, Response<TodoItem> response) {
                    Log.i("Response", ""+response.body());
            }

            @Override
            public void onFailure(Call<TodoItem> call, Throwable t) {
                Log.i("Update Unsuccessfull", "Update Unsuccessfult");
            }
        });
    }

    public void initToDoView(Integer userId){

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Create a service instance
        TodoApiService service = RetrofitInstance.todoApiService();

        // Call the API endpoint
        Call<List<TodoItem>> call = service.getTodoItemsByUserId(userId);
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
