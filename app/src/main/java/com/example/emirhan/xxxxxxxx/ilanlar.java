package com.example.emirhan.xxxxxxxx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Array;
import android.net.Uri;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emirhan on 3.11.2017.
 */

public class ilanlar extends AppCompatActivity{


    TextView txtview_id;
    ImageView imgview_resim;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilanlar);

        txtview_id = (TextView) findViewById(R.id.txtview_id);
        imgview_resim = (ImageView) findViewById(R.id.imgview_resim);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(ilanlar.this);
        //this is the url where you want to send the request
        //TODO: replace with your own url to send request, as I am using my own localhost for this tutorial
        String url = "http://emirhanpervanlar.com/project/pets/pets/rest_test2.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Display the response string.
//                        String [] dizimiz;
//                        dizimiz=new String[2];
//                        dizimiz[1]=response;
                        String cumle = response;
                        String[] kelime = null;
                        kelime = cumle.split(","); /* , referansına gore parçalıyor*/

                        txtview_id.setText(kelime[0]);


                        new DownloadImageTask((ImageView) findViewById(R.id.imgview_resim))
                                .execute(kelime[1]);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtview_id.setText("That didn't work!");
            }
        }) {
            //adding parameters to the request

        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }



}
