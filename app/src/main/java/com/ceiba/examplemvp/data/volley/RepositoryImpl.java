package com.ceiba.examplemvp.data.volley;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ceiba.examplemvp.data.entities.CategoryStore;
import com.ceiba.examplemvp.interfaces.MainInterface;
import com.ceiba.examplemvp.interfaces.Repository;
import com.ceiba.examplemvp.view.activities.BaseContext;
import com.google.gson.Gson;

public class RepositoryImpl implements Repository {

    private RequestQueue queue;
    private MainInterface.Model model;
    private Gson gson;

    public RepositoryImpl(MainInterface.Model model) {
        this.model = model;
        gson = new Gson();
        queue = Volley.newRequestQueue(BaseContext.getContext());
    }


    @Override
    public void select() {
        String url = "http://rapientrega.co/stores-ms/api/stores/";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("StoreApi", response);
                        CategoryStore categoryStore = gson.fromJson(response, CategoryStore.class);
                        model.showStores(categoryStore.getStores());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("StoreApi", "Error: " + error.getMessage());
                    }
                });
        queue.add(stringRequest);
    }
}
