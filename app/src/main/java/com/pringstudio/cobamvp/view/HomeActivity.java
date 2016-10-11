package com.pringstudio.cobamvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pringstudio.cobamvp.R;
import com.pringstudio.cobamvp.model.BuahModel;
import com.pringstudio.cobamvp.presenter.HomePresenter;
import com.pringstudio.cobamvp.presenter.IHomePresenter;
import com.pringstudio.cobamvp.view.adapter.BuahAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IHomeView{
    EditText mEditBuah;
    Button mAddButton;
    RecyclerView mRecyclerBuah;

    // Jembatan Presenter
    IHomePresenter homePresenter;

    // Adapter
    BuahAdapter buahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mEditBuah = (EditText) findViewById(R.id.editBuah);
        mAddButton = (Button) findViewById(R.id.btnAddBuah);

        homePresenter = new HomePresenter(this);

        // Init recyclerview
        mRecyclerBuah = (RecyclerView) findViewById(R.id.listBuah);
        mRecyclerBuah.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // Init recycler adapter
        buahAdapter = new BuahAdapter(getApplicationContext());
        mRecyclerBuah.setAdapter(buahAdapter);
    }

    // Tombol add click
    public void btnAddClick(View v){
        String buah = mEditBuah.getText().toString();

        if(!buah.isEmpty()){
            homePresenter.addBuah(buah,"Deskripsi buah", 87);
        }
    }

    @Override
    public void onRefreshData() {
        buahAdapter.updateData(homePresenter.getAllBuah());
        buahAdapter.notifyDataSetChanged();
        Log.d("Home",homePresenter.getAllBuah().toString());
    }

    @Override
    public void onClearForm() {
        mEditBuah.setText("");
    }
}
