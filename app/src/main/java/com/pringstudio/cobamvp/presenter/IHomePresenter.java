package com.pringstudio.cobamvp.presenter;

import com.pringstudio.cobamvp.model.BuahModel;

import java.util.List;

/**
 * Created by sucipto on 10/11/16.
 */

public interface IHomePresenter {
    void addBuah(String nama, String deskripsi, int jumlah);
    void hapusBuah(int index);
    List<BuahModel> getAllBuah();
}
