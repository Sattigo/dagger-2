package com.hariofspades.dagger2advanced;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.RandomUserComponent;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.ContextModule;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RecyclerView recyclerView;
    RandomUserAdapter mAdapter;
    RandomUsersApi randomUsersApi;

    Picasso picasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        RandomUserComponent daggerRandomUserComponent = DaggerRandomUserComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        picasso = daggerRandomUserComponent.getPicasso();
        randomUsersApi = daggerRandomUserComponent.getRandomUserService();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}