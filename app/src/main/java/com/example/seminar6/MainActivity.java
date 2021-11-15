package com.example.seminar6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private ListView listView;
private OrasAdapter adapter;
private JSONRead jsonRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        adapter=new OrasAdapter(createList());
        listView.setAdapter(adapter);

        jsonRead=new JSONRead();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                jsonRead.read("https://jsonkeeper.com/b/HXJ5", new IResponse() {
                    @Override
                    public void onSuccess(List<Oras> list) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.updateList(list);
                            }
                        });


                    }

                    @Override
                    public void onError(String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });

            }
        });

        thread.start();

    }

    private List<Oras> createList(){
        ArrayList<Oras> lista=new ArrayList<>();

        Oras oras1=new Oras("Bucuresti", 2500, "aaaaaaaaaa");
        Oras oras2=new Oras("Roman", 1500, "bbbbbbbbbb");
        Oras oras3=new Oras("Piatra Neamt", 2000, "ccccccccc");


        lista.add(oras1);
        lista.add(oras2);
        lista.add(oras3);

        return lista;
    }}