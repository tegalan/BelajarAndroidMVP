package com.pringstudio.cobamvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pringstudio.cobamvp.R;
import com.pringstudio.cobamvp.model.BuahModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sucipto on 10/11/16.
 */

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.BuahHolder>{

    Context mContext;
    List<BuahModel> mListBuah;

    public BuahAdapter(Context context){
        this.mContext = context;
        this.mListBuah = new ArrayList<>();
    }

    public void updateData(List<BuahModel> buah){
        this.mListBuah = buah;
        Log.d("BuahAdapter","Jumlah data "+buah.size());
    }

    @Override
    public BuahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_buah, parent, false);
        return new BuahHolder(view);
    }

    @Override
    public void onBindViewHolder(BuahHolder holder, int position) {
        BuahModel buah = mListBuah.get(position);

        holder.nama.setText(buah.getNama());
        holder.desc.setText(buah.getDeskripsi());
        holder.jumlah.setText(String.valueOf(buah.getJumlah()));
    }

    @Override
    public int getItemCount() {
        Log.d("Adapter","getItemCount()");
        return mListBuah.size();
    }

    // Holder Class
    class BuahHolder extends RecyclerView.ViewHolder {

        public TextView nama;
        public TextView desc;
        public TextView jumlah;

        public BuahHolder(View view){
            super(view);

            nama = (TextView) view.findViewById(R.id.textNama);
            desc = (TextView) view.findViewById(R.id.textDeskripsi);
            jumlah = (TextView) view.findViewById(R.id.textJumlah);
        }

    }
}
