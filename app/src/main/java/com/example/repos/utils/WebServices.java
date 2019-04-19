package com.example.repos.utils;

import com.example.repos.data.entities.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("repos")
    Call<List<Repo>> getRepos();

}
