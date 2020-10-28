package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        progress = (ProgressBar)findViewById(R.id.progressBar);
        btn = (Button)findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });


        progress.setVisibility(View.INVISIBLE);

    }


    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(100);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), HOME_ACT.class);
            startActivity(i);

        }
    }


}