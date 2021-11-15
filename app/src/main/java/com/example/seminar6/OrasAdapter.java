package com.example.seminar6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrasAdapter extends BaseAdapter {

    private List<Oras> listaOrase=new ArrayList<>();

    public OrasAdapter(List<Oras> listaOrase) {
        this.listaOrase = listaOrase;
    }

    @Override
    public int getCount() {
        return listaOrase.size();
    }

    @Override
    public Oras getItem(int position) {
        return listaOrase.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.macheta_oras, parent, false);
        TextView tvDenumire=view.findViewById(R.id.tvDenumire);
        TextView tvPopulatie=view.findViewById(R.id.tvPopulatie);
        TextView tvDescriere=view.findViewById(R.id.tvDescriere);


        Oras temp=listaOrase.get(position);
        tvDenumire.setText(temp.getDenumire());
        tvPopulatie.setText(temp.getPopulatie().toString());


        return view;
    }

    public void updateList(List<Oras> listaNoua)
    {
        listaOrase.addAll(listaNoua);
        notifyDataSetChanged();
    }
}
