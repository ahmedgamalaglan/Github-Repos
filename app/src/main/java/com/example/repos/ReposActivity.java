package com.example.repos;


import android.os.Bundle;
import android.widget.Toast;

import com.example.repos.adapters.ReposAdapter;
import com.example.repos.data.viewmodels.ReposViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReposActivity extends AppCompatActivity {
    private static final String TAG = "ReposActivity";

    private ReposViewModel viewModel;
    RecyclerView recyclerView;
    ReposAdapter reposAdapter;
    LinearLayoutManager layoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        recyclerView = findViewById(R.id.recycler_view_id);

        setUpRecyclerView();
        viewModel = ViewModelProviders.of(this).get(ReposViewModel.class);
        viewModel.getReposList().observe(this, repos -> {
            if (repos != null) {
                reposAdapter.setRepos(repos);
                Toast.makeText(this, repos.size() + "==========", Toast.LENGTH_LONG).show();
            } else Toast.makeText(this, "repos is null==========", Toast.LENGTH_LONG).show();
        });


    }

    void setUpRecyclerView() {
        reposAdapter = new ReposAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(reposAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void setUpToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Repositories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
