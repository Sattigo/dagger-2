package com.sattigo.dagger2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sattigo.dagger2.MainActivityFeature.DaggerMainActivityComponent;
import com.sattigo.dagger2.MainActivityFeature.MainActivityComponent;
import com.sattigo.dagger2.MainActivityFeature.MainActivityModule;
import com.sattigo.dagger2.adapter.RandomUserAdapter;
import com.sattigo.dagger2.application.RandomUserApplication;
import com.sattigo.dagger2.interfaces.RandomUsersApi;
import com.sattigo.dagger2.model.RandomUsers;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Inject
    RandomUsersApi randomUsersApi;

    @Inject
    RandomUserAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        afterActivityLevelComponent();
        populateUsers();
    }

    private void afterActivityLevelComponent() {
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUserComponent(RandomUserApplication.get(this).getRandomUserApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = getRandomUserService().getRandomUsers(33);
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(@NonNull Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
                if(response.isSuccessful() && response.body() != null) {
                    mAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<RandomUsers> call,@NonNull  Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }

    public RandomUsersApi getRandomUserService(){
        return randomUsersApi;
    }


}
