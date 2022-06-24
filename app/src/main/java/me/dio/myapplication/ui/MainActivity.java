package me.dio.myapplication.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import me.dio.myapplication.R;
import me.dio.myapplication.data.MatchesAPI;
import me.dio.myapplication.databinding.ActivityMainBinding;
import me.dio.myapplication.domain.Match;
import me.dio.myapplication.ui.adapter.MatcheAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private   ActivityMainBinding binding;
    private MatchesAPI matchesApi;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();
        setupHTTPClient();
    }

    private void setupHTTPClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mikemedeiros.github.io/match-simulator-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        matchesApi =  retrofit.create(MatchesAPI.class);
    }

    private void setupFloatingActionButton() {
        //TODO criar evento de criação e simluação de partida
    }

    private void setupMatchesRefresh() {
        //TODO atualizar as partidas
    }

    private void setupMatchesList(){
        binding.rvMatch.setHasFixedSize(true);
        binding.rvMatch.setLayoutManager(new LinearLayoutManager(this));
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if(response.isSuccessful()){
                    List<Match> matches = response.body();
                    MatcheAdapter matcheAdapter = new MatcheAdapter(matches);
                    binding.rvMatch.setAdapter(matcheAdapter);
                }else{
                    showErrorMassage();
                }
            }



            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                showErrorMassage();
            }
        });
    }
    private void showErrorMassage() {
        Snackbar.make(binding.fabSimulator, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }
}
