package com.example.seminar6;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONRead {

    public void read(String param_url,IResponse response){
        try {
            URL url=new URL(param_url);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();

            InputStream stream=connection.getInputStream();
            InputStreamReader streamReader=new InputStreamReader(stream);
            BufferedReader bufferedReader=new BufferedReader(streamReader);

            StringBuilder builder=new StringBuilder();
            String line="";

            while((line=bufferedReader.readLine())!=null){

                builder.append(line);
            }

            List<Oras> list=Parsare(builder.toString());

            response.onSuccess(list);

            Log.v("rezultat",list.toString());

            bufferedReader.close();
            streamReader.close();
            stream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Oras> Parsare(String jsonString){

        List<Oras> listaJSON=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(jsonString);
            JSONArray array=object.getJSONArray("orase");
            for(int i=0; i<array.length(); i++){
                JSONObject jsonObject=array.getJSONObject(i);
                String nume=jsonObject.getString("nume");
                Integer populatie=jsonObject.getInt("populatie");
                String descriere=jsonObject.getString("descriere");

                Oras oras=new Oras(nume,populatie,descriere);
                listaJSON.add(oras);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaJSON;
    }
}
