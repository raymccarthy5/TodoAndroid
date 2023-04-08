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

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    private Integer userId;
    private Integer id;

    //Form fields
    private EditText titleEdit;
    private EditText descriptionEdit;
    private EditText dueDateEdit;


    private TodoItem todoItem;
    private FloatingActionButton updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = getIntent().getIntExtra("id", 0);
        userId = getIntent().getIntExtra("userId", 0);



        // Create a service instance
        TodoApiService service = RetrofitInstance.todoApiService();


        Log.i("id", "id: " +id);



        // Call the API endpoint
        Call<TodoItem> call = service.getTodoItemById(id);

        titleEdit = findViewById(R.id.titleEdit);
        descriptionEdit = findViewById(R.id.descriptionEdit);
        dueDateEdit = findViewById(R.id.dueDateEdit);

        updateButton = findViewById(R.id.checkButtonEdit);

        call.enqueue(new Callback<TodoItem>() {
            @Override
            public void onResponse(Call<TodoItem> call, Response<TodoItem> response) {
                Log.i("todoItem", "todoItem: " +response);
                todoItem = response.body();
                titleEdit.setText(todoItem.getTitle());
                descriptionEdit.setText(todoItem.getDescription());
                dueDateEdit.setText(todoItem.getDueDate());
            }

            @Override
            public void onFailure(Call<TodoItem> call, Throwable t) {
                Log.i("failed", "failed: " +t);

            }
        });
    }


    public void updateToDoItem(View view){



        Log.i("toItem", "toItemTitle: " +todoItem.getTitle());


        TodoApiService service = RetrofitInstance.todoApiService();
        
        todoItem.setTitle(titleEdit.getText().toString());
        todoItem.setDueDate(dueDateEdit.getText().toString());
        todoItem.setDescription(descriptionEdit.getText().toString());

        HashMap<String, Object> updateRequest = new HashMap<>();

        updateRequest.put("id", todoItem.getId());
        updateRequest.put("userId", todoItem.getUserId());
        updateRequest.put("dueDate", todoItem.getDueDate());
        updateRequest.put("title", todoItem.getTitle());
        updateRequest.put("description", todoItem.getDescription());
        updateRequest.put("status", todoItem.getStatus());

        Log.i("id for request", "id for request: " +id);


        // Call the API endpoint
        Call<TodoItem> call = service.editTodoItem(id, updateRequest);

        Log.i("toDoOoutput", "updateToDoItem: "
        +todoItem.getTitle()
        );
        
        call.enqueue(new Callback<TodoItem>() {
            @Override
            public void onResponse(Call<TodoItem> call, Response<TodoItem> response) {

                Log.i("toDoOoutput", "updateToDoItem: "
                        +response
                );


                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<TodoItem> call, Throwable t) {
                Log.i("failed", "onFailure: "+t);
            }
        });



    }
}