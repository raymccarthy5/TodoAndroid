package com.example.todoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Credential Buttons
    private AutoCompleteTextView email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void onSignIn(View view){
        this.email = findViewById(R.id.email);
        this.password = findViewById(R.id.password);

        Toast.makeText(this, "Email: "+this.email.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Password: "+this.password.getText().toString(), Toast.LENGTH_SHORT).show();


    }
}