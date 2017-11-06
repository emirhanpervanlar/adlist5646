package com.example.emirhan.xxxxxxxx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView _name, _email, _response,_pass;
    android.support.v7.widget.AppCompatButton _sendRequest;
    ProgressBar _proProgressBar;
    Button _ilanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooking the UI views for usage
        _name = (TextView) findViewById(R.id.name);
        _email = (TextView) findViewById(R.id.email);
        _pass = (TextView) findViewById(R.id.pass);
        _response = (TextView) findViewById(R.id.response);
        _proProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        _sendRequest = (AppCompatButton) findViewById(R.id.send_request);
        _ilanlar = (Button) findViewById(R.id.btn_ilanlar);


        //hooking onclick listener of button
        _sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                //this is the url where you want to send the request
                //TODO: replace with your own url to send request, as I am using my own localhost for this tutorial
                String url = "http://emirhanpervanlar.com/project/pets/pets/rest_test2.php";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the response string.
                                _response.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        _response.setText("That didn't work!");
                    }
                }) {
                    //adding parameters to the request
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("token", "a153dd6s33xv6uy9hgf23b16gh");
                        params.put("name", _name.getText().toString());
                        params.put("email", _email.getText().toString());
                        params.put("pass", _pass.getText().toString());

                        return params;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });


    }
            public void ilanlaragec(View v) {



                Intent ilanagec=new Intent(MainActivity.this,ilanlar.class);
                startActivity(ilanagec);


            }
        }




