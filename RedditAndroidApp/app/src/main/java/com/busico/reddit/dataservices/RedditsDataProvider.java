package com.busico.reddit.dataservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedditsDataProvider {

    Retrofit retrofit;

    public RedditsDataProvider() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RedditDataService createRedditDataService() {
        return retrofit.create(RedditDataService.class);
    }
}
