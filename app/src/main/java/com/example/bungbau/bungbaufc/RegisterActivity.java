package com.example.bungbau.bungbaufc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegisterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = (EditText) findViewById(R.id.edit_username);
        final EditText password = (EditText) findViewById(R.id.edit_password);
        final EditText email    = (EditText) findViewById(R.id.edit_email);

        Button btnConfirm = (Button) findViewById(R.id.button_Confirm);

        if(btnConfirm != null)
        {
            btnConfirm.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    AsyncTask<Void, Void, Response> httpRequestTask = new AsyncTask<Void, Void, Response>()
                    {
                        @Override
                        protected Response doInBackground(Void... voids)
                        {
                            OkHttpClient client = new OkHttpClient();

                            RequestBody formBody = new FormBody.Builder()
                                    .add("username", username.getText().toString())
                                    .add("password", password.getText().toString())
                                    .add("email", email.getText().toString())
                                    .build();
                            Request request = new Request.Builder()
                                    .url("http://161.246.34.191:8001/")
                                    .post(formBody)
                                    .build();

                            try
                            {
                                Response response = client.newCall(request).execute();
                                return response;
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }

                            return null;
                        }

                        @Override
                        protected void onPostExecute(Response response)
                        {
                            if(response == null)
                            {
                                Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT);
                                return;
                            }
                            if(response.code() == 200)
                            {
                                RegisterActivity.this.setResult(1);
                                RegisterActivity.this.finish();
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT);
                            }
                        }
                    };

                    httpRequestTask.execute();
                }
            });
        }



    }
}
