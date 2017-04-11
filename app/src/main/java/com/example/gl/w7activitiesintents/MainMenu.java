package com.example.gl.w7activitiesintents;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MainMenu extends AppCompatActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

       text = (TextView) findViewById(R.id.random);
       // Intent intent = getIntent();
       // int data = intent.getIntExtra("data",-1);
       // text.setText("Random is :" + data);

        ;

            Thread t = new Thread(new Runnable() {
                Document doc;
                Element element;
                @Override
                public void run() {
                    try {
                        doc = Jsoup.connect("http://ybu.edu.tr/muhendislik/bilgisayar/").get();
                        element = doc.select("div.caContent").first();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(element.text());
                            }
                        });


                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            });
        t.start();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
