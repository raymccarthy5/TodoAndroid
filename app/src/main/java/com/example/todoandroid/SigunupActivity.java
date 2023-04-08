package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.todoandroid.Model.UserModel;
import com.example.todoandroid.Model.VerificationResponse;
import com.example.todoandroid.Service.RetrofitInstance;
import com.example.todoandroid.Service.TodoApiService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigunupActivity extends AppCompatActivity {

    private AutoCompleteTextView username;
    private AutoCompleteTextView email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigunup);
    }



    public void onSignUp(View view){


        username = findViewById(R.id.usernameCreate);
        password = findViewById(R.id.passwordCreate);
        email = findViewById(R.id.emailCreate);

        UserModel userModel = new UserModel(username.getText().toString(), email.getText().toString(), password.getText().toString());


        // Create a service instance
        TodoApiService service = RetrofitInstance.todoApiService();


        Call<UserModel> call = service.createUserAccount(userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.i("log", "createAccountResponse: " +response);

                Intent intent = new Intent(SigunupActivity.this, MainActivity.class);
                intent.putExtra("userId", response.body().getId());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });





    }
}