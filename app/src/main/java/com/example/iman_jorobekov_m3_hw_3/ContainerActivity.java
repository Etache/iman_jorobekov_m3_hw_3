package com.example.iman_jorobekov_m3_hw_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.iman_jorobekov_m3_hw_3.databinding.ActivityContainerBinding;

import java.io.Serializable;

public class ContainerActivity extends AppCompatActivity {

    ActivityContainerBinding binding;
    FlatModel flatModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onGetExtra();
    }

    public void onGetExtra() {
        flatModel = (FlatModel) getIntent().getSerializableExtra("flat");

        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("flat", flatModel);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fr_container,fragment).commit();
    }
}