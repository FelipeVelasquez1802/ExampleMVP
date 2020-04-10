package com.ceiba.examplemvp.presenter;

import com.ceiba.examplemvp.data.entities.Store;
import com.ceiba.examplemvp.interfaces.MainInterface;
import com.ceiba.examplemvp.model.MainModel;

import java.util.ArrayList;

public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.view view;
    private MainInterface.Model model;

    public MainPresenter(MainInterface.view view) {
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public void initials() {
        view.initialObjects();
        view.initialElements();
    }

    @Override
    public void consult() {
        view.showLoading();
        model.consult();
    }

    @Override
    public void showStores(ArrayList<Store> stores) {
        view.hideLoading();
        view.showStores(stores);
    }
}
