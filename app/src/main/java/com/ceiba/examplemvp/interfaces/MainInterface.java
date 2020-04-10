package com.ceiba.examplemvp.interfaces;

import com.ceiba.examplemvp.data.entities.Store;

import java.util.ArrayList;

public interface MainInterface {
    interface view {
        void initialElements();

        void initialObjects();

        void showLoading();

        void hideLoading();

        void showStores(ArrayList<Store> stores);
    }

    interface Presenter {
        void initials();

        void consult();

        void showStores(ArrayList<Store> stores);
    }

    interface Model {
        void consult();

        void showStores(ArrayList<Store> stores);
    }
}
