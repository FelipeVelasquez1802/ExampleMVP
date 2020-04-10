package com.ceiba.examplemvp.model;

import com.ceiba.examplemvp.data.entities.Store;
import com.ceiba.examplemvp.data.volley.RepositoryImpl;
import com.ceiba.examplemvp.interfaces.MainInterface;
import com.ceiba.examplemvp.interfaces.Repository;

import java.util.ArrayList;

public class MainModel implements MainInterface.Model {
    private MainInterface.Presenter presenter;
    private Repository repository;

    public MainModel(MainInterface.Presenter presenter) {
        this.presenter = presenter;
        repository = new RepositoryImpl(this);
    }

    @Override
    public void consult() {
        repository.select();
    }

    @Override
    public void showStores(ArrayList<Store> stores) {
        presenter.showStores(stores);
    }
}
