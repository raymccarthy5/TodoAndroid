package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.Service.RetrofitInstance;
import com.example.todoandroid.Service.TodoApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmDeleteActivity extends AppCompatActivity {

    private Button yesButton;
    private Button noButton;
    private Integer id;
    private Integer userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_delete);

         id = getIntent().getIntExtra("id", 0);
         userId = getIntent().getIntExtra("userId", 0);

    }

    public void noConfirmation(View view) {
        Intent intent = new Intent(ConfirmDeleteActivity.this, MainActivity.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
    }



    public void yesConfirmation(View view){

        TodoApiService service = RetrofitInstance.todoApiService();

        // Call the API endpoint
        Call<Void> call = service.deleteTodoItem(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.isSuccessful()){
                    Log.i("Deleted", "ToDoItem Id Deleted: "+id);
                    Intent intent = new Intent(ConfirmDeleteActivity.this, MainActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                }


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i("Not successful", "Not successful "+t);


            }
        });
    }
}