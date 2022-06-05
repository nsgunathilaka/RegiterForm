package com.example.regiterform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText uname,uemail,uphone,umessage;
    Button submit;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        uname = findViewById(R.id.name);
        uemail = findViewById(R.id.email);
        uphone = findViewById(R.id.phone);
        umessage = findViewById(R.id.message);
        submit = findViewById(R.id.btnSubmit);
        DB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = uname.getText().toString();
                String email = uemail.getText().toString();
                String phone = uphone.getText().toString();
                String message = umessage.getText().toString();

                if (name.equals("") && email.equals("") && phone.equals("") && message.equals("")) {
                    Toast.makeText(HomeActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean insert = DB.inserFeedbacktData(name, email, phone, message);
                    if(insert==true){
                        Toast.makeText(HomeActivity.this, "Feedback sent successfully", Toast.LENGTH_SHORT).show();
                        uname.setText("");
                        uemail.setText("");
                        uphone.setText("");
                        umessage.setText("");
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(HomeActivity.this, "Feedback sent failed", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}