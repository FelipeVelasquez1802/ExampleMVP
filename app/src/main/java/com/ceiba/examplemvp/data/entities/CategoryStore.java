package com.ceiba.examplemvp.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryStore {
    @SerializedName("stores_categories")
    @Expose
    private ArrayList<Store> stores;

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }
}
