package com.example.repos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.repos.R;
import com.example.repos.data.entities.Repo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {


    private List<Repo> mRepos;

    public ReposAdapter() {
        mRepos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parentView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parentView.getContext());
        View view = inflater.inflate(R.layout.repo_item_view, parentView, false);
        return new ReposViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        holder.bind(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public void setRepos(List<Repo> repos) {
        this.mRepos = repos;
        notifyDataSetChanged();
    }


    public class ReposViewHolder extends RecyclerView.ViewHolder {
        public TextView repoId, repoName, repoUrl;

        public ReposViewHolder(@NonNull View itemView) {
            super(itemView);
            repoId = itemView.findViewById(R.id.tv_repo_id);
            repoName = itemView.findViewById(R.id.tv_repo_name);
            repoUrl = itemView.findViewById(R.id.tv_repo_url);

        }

        void bind(Repo repo) {
            repoId.setText(Integer.toString(repo.getId()));
            repoName.setText(repo.getName());
            repoUrl.setText(repo.getUrl());

        }

    }
}
