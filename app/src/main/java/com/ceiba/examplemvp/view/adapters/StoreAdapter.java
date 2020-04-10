package com.ceiba.examplemvp.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ceiba.examplemvp.R;
import com.ceiba.examplemvp.data.entities.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private ArrayList<Store> stores;

    public StoreAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_store, null);
        StoreViewHolder viewHolder = new StoreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        Store store = stores.get(position);
        holder.name.setText(store.getName());
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
        }
    }
}
