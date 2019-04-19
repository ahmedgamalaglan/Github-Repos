package com.example.repos.data.viewmodels;

import android.app.Application;

import com.example.repos.data.entities.Repo;
import com.example.repos.data.repositories.ReposRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ReposViewModel extends AndroidViewModel {

    private static final String TAG = "ReposViewModel";
    private LiveData<List<Repo>> reposList;
    private ReposRepository reposRepository;

    public ReposViewModel(@NonNull Application application) {
        super(application);
        reposRepository = new ReposRepository();
        reposList = reposRepository.getOnlineRepos();

    }

    public LiveData<List<Repo>> getReposList() {
        return reposList;
    }


}