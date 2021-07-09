package com.example.android.calculator1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvAttempts);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Name.length()==0){
                    Toast.makeText(MainActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                }
                else if(Password.length()==0){
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, Calciwork.class);
            startActivity(intent);
        }
        else if((userName.equals("Abhi")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, Calciwork.class);
            startActivity(intent);
        }

        else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));
            Toast.makeText(this, "TRY AGAIN", Toast.LENGTH_SHORT).show();
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}