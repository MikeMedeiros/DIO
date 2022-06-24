package me.dio.myapplication.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

import me.dio.myapplication.databinding.CardItemBinding;
import me.dio.myapplication.domain.Match;
import me.dio.myapplication.ui.DetailActivity;

public class MatcheAdapter extends RecyclerView.Adapter<MatcheAdapter.ViewHolder> {


    private List<Match> matches;

    public MatcheAdapter(List<Match> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardItemBinding binding = CardItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match match = matches.get(position);


        //adapta os dados da partida(recuperados da API) para nosso layout
        holder.binding.tvNameTeam.setText(match.getHomeTeam().getName());
        holder.binding.tvNameTeamVisictor.setText(match.getAwayTeam().getName());

    }

    @Override
    public int getItemCount() {
        return matches.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardItemBinding binding;

        public ViewHolder(CardItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}