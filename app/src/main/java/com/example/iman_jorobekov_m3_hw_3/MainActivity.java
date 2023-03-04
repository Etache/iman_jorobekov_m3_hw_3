package com.example.iman_jorobekov_m3_hw_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Adapter;

import com.example.iman_jorobekov_m3_hw_3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClick{
    ActivityMainBinding binding;
    FlatAdapter adapter;
    ArrayList<FlatModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fillOurList();
        initRecycler();
    }

    private void initRecycler() {
        adapter = new FlatAdapter(arrayList, this);
        binding.rvFlat.setAdapter(adapter);
    }

    private void fillOurList() {
        arrayList.add(new FlatModel("1 rooms", "Советская 53", R.drawable.flat_one));
        arrayList.add(new FlatModel("2 rooms", "Пр. Мира 303", R.drawable.flat_two));
        arrayList.add(new FlatModel("2 rooms", "Где-то в залупе", R.drawable.flat_three));
        arrayList.add(new FlatModel("3 rooms", "Ахунбаева 21", R.drawable.flat_four));
        arrayList.add(new FlatModel("4 rooms", "Кок-Джар", R.drawable.flat_five));
    }


    @Override
    public void onClick(FlatModel flatModel) {
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("flat", flatModel);
        startActivity(intent);
    }
}