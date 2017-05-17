package com.busico.reddit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.busico.reddit.dataservices.RedditDataService;
import com.busico.reddit.dataservices.RedditsDataProvider;

public class ListRedditsActivity extends AppCompatActivity {

    private RecyclerView redditsRecyclerView;
    private ListRedditsAdapter listRedditsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reddits);

        redditsRecyclerView = (RecyclerView) findViewById(R.id.redditsRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        redditsRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                redditsRecyclerView.getContext(), layoutManager.getOrientation());
        redditsRecyclerView.addItemDecoration(dividerItemDecoration);

        RedditDataService redditDataService = new RedditsDataProvider().createRedditDataService();
        listRedditsAdapter = new ListRedditsAdapter(this, redditDataService);

        redditsRecyclerView.setAdapter(listRedditsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listRedditsAdapter.reloadReddits();
    }
}
