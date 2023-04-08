package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Service.RetrofitInstance;
import com.example.todoandroid.Service.TodoApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private EditText dueDate;
    private FloatingActionButton saveButton;
    private Integer userId;
    private Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        userId = getIntent().getIntExtra("userId", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }



    public void addTodoItem(View view) throws ParseException {


        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        dueDate = findViewById(R.id.dueDate);
        status = false;


        //Format
        String formattedDesc, formaetedTitle, formattedDate;

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = inputFormat.parse(dueDate.getText().toString());
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String outputDate = outputFormat.format(date);
        formaetedTitle = title.getText().toString();
        formattedDesc = description.getText().toString();


        // Create a service instance
        TodoApiService service = RetrofitInstance.todoApiService();

        HashMap<String, Object> createTodoItemRequest = new HashMap<>();
        // Request Json Body
        createTodoItemRequest.put("title", formaetedTitle);
        createTodoItemRequest.put("description", formattedDesc);
        createTodoItemRequest.put("dueDate", outputDate);
        createTodoItemRequest.put("userId", userId);
        createTodoItemRequest.put("status", false);


        // Call the API endpoint
        Call<TodoItem> call = service.createTodoItem(createTodoItemRequest);

        call.enqueue(new Callback<TodoItem>() {
            @Override
            public void onResponse(Call<TodoItem> call, Response<TodoItem> response) {

                Log.i("response", "onResponse: " +response);

                if(response.isSuccessful()){
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);

                }
            }

            @Override
            public void onFailure(Call<TodoItem> call, Throwable t) {
                Log.i("failed", "Failed to add: ");

            }
        });


    }
}