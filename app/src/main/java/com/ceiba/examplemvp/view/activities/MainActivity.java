package com.ceiba.examplemvp.view.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ceiba.examplemvp.R;
import com.ceiba.examplemvp.data.entities.Store;
import com.ceiba.examplemvp.interfaces.MainInterface;
import com.ceiba.examplemvp.presenter.MainPresenter;
import com.ceiba.examplemvp.view.adapters.StoreAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainInterface.view, View.OnClickListener {

    private MainInterface.Presenter presenter;

    private ProgressBar progressBar;
    private StoreAdapter adapter;
    private ArrayList<Store> stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        presenter.initials();
    }

    @Override
    public void initialElements() {
        progressBar = findViewById(R.id.progress_circular);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initialObjects() {
        stores = new ArrayList<>();
        adapter = new StoreAdapter(stores);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showStores(ArrayList<Store> stores) {
        this.stores.addAll(stores);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btConsult:
                presenter.consult();
                break;
        }
    }
}
