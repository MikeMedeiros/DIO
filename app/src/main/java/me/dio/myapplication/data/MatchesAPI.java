package me.dio.myapplication.data;

import java.util.List;

import me.dio.myapplication.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesAPI {

    @GET("matches.json")
    Call<List<Match>>getMatches();
}
