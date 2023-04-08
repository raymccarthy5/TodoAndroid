package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todoandroid.Model.VerificationResponse;
import com.example.todoandroid.Service.RetrofitInstance;
import com.example.todoandroid.Service.TodoApiService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    //Credential Buttons
    private AutoCompleteTextView username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void onSignIn(View view){
        this.username = findViewById(R.id.username);
        this.password = findViewById(R.id.password);

        loginEmailAndPassword(this.username.getText().toString().trim(), this.password.getText().toString().trim());
    }


    public void onSignUp(View view){
        Intent intent = new Intent(LoginActivity.this, SigunupActivity.class);
        startActivity(intent);

    }


    public void loginEmailAndPassword(String username, String password){

        //check for empty text
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){

            return;
        }

        // Create a service instance
        TodoApiService service = RetrofitInstance.todoApiService();

        // Set Data
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);


        Call<VerificationResponse> call = service.signInUser(credentials);

        call.enqueue(new Callback<VerificationResponse>() {
            @Override
            public void onResponse(Call<VerificationResponse> call, Response<VerificationResponse> response) {

                Log.i("response", ""+response.body().getId());
                if(!response.body().getVerified()){
                    Toast.makeText(LoginActivity.this, "User Credentials incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("userId", response.body().getId());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<VerificationResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "An error has occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }
}