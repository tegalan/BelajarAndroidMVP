package com.pringstudio.cobamvp.presenter;

import com.pringstudio.cobamvp.model.BuahModel;
import com.pringstudio.cobamvp.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sucipto on 10/11/16.
 */

public class HomePresenter implements IHomePresenter {
    IHomeView homeView;

    List<BuahModel> mBuahList = new ArrayList<>();

    public HomePresenter(IHomeView homeView){
        this.homeView = homeView;
    }

    @Override
    public void addBuah(String nama, String deskripsi, int jumlah) {
        BuahModel buahModel = new BuahModel();
        buahModel.setNama(nama);
        buahModel.setDeskripsi(deskripsi);
        buahModel.setJumlah(jumlah);

        // Tambah buah ke list model
        mBuahList.add(buahModel);

        // Refresh view
        homeView.onRefreshData();

        // Clear Form
        homeView.onClearForm();
    }

    @Override
    public void hapusBuah(int index) {
        mBuahList.remove(index);
    }

    @Override
    public List<BuahModel> getAllBuah() {
        return mBuahList;
    }
}
