package com.example.gl.w7activitiesintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

    }

    public void checkUser(View view) {

        String uName = userName.getText().toString();
        String p = pass.getText().toString();
        if(p == "" || uName == ""){
            Toast.makeText(this, "Enter something!!", Toast.LENGTH_SHORT).show();
        }
        else if(p.equals("admin") && uName.equals("admin")){

            Random r = new Random();
            int random = r.nextInt(10);

            Intent intent = new Intent(this,MainMenu.class);

            //put data
            intent.putExtra("data", random);

            startActivity(intent);
        }

        else if(p.equals("secret") && uName.equals("admin")){

            //secret call
            //implicit intent
            Uri number = Uri.parse("tel:03123245515");
            Intent intent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(intent);
        }
        else{
            //incorrect trial
            Log.w("IBR", "User try to access 2nd activity!!!");
        }

    }
}
