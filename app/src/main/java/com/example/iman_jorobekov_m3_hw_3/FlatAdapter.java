package com.example.iman_jorobekov_m3_hw_3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iman_jorobekov_m3_hw_3.databinding.ItemFlatBinding;

import java.util.ArrayList;

public class FlatAdapter extends RecyclerView.Adapter<ViewHolderFlat> {

    private ArrayList<FlatModel> arrayList = new ArrayList<>();
    OnItemClick onItemClick;

    public FlatAdapter(ArrayList<FlatModel> arrayList, MainActivity onItemClick) {
        this.arrayList = arrayList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolderFlat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderFlat(ItemFlatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFlat holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(arrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

class ViewHolderFlat extends RecyclerView.ViewHolder {
    ItemFlatBinding binding;

    public ViewHolderFlat(ItemFlatBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void onBind(FlatModel flatModel) {
        binding.tvName.setText(flatModel.getName());
        binding.tvDescription.setText(flatModel.getDescription());
        binding.imgFlat.setImageResource(flatModel.getImage());
    }
}
