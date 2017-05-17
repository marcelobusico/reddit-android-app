package com.busico.reddit.dataservices;

import com.busico.reddit.model.RedditDataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RedditDataService {

    @GET("top.json")
    Call<RedditDataModel> getTopReddits();
}
