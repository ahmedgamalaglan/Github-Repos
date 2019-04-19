package com.example.repos.data.repositories;

import android.util.Log;

import com.example.repos.data.entities.Repo;
import com.example.repos.utils.ApiHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ReposRepository {

    private static final String TAG = "ReposRepository";
    private MutableLiveData<List<Repo>> mRepos;

    public ReposRepository() {
        mRepos = new MutableLiveData<>();
    }

    public LiveData<List<Repo>> getRepos(){
        return mRepos;
    }


    public LiveData<List<Repo>> getOnlineRepos() {
        final MutableLiveData<List<Repo>> res = new MutableLiveData<>();
        ApiHelper.getClient().getRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful() && response.body().size() != 0) {
                    res.postValue(response.body());
//                    Log.d(TAG, "onResponse: ===========================================" + res.getValue().size());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(TAG, "onFailure: no response from web");
            }
        });
        return res;
    }

}
