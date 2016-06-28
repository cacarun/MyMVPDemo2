package com.android.mvp2.service;

import com.android.mvp2.data.bean.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubApiService {
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);


    // e.g.
    /**
     http://square.github.io/retrofit/
     */
}