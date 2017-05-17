package com.busico.reddit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.busico.reddit.dataservices.RedditDataService;
import com.busico.reddit.model.RedditDataModel;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRedditsAdapter extends RecyclerView.Adapter<ListRedditsViewHolder> {

    private RedditDataService redditDataService;
    private List<RedditDataModel> redditsList;
    private Context context;

    public ListRedditsAdapter(Context context, RedditDataService redditDataService) {
        this.context = context;
        this.redditDataService = redditDataService;
    }

    @Override
    public ListRedditsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_reddits_cell, parent, false);
        return new ListRedditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListRedditsViewHolder holder, int position) {
        RedditDataModel redditDataModel = redditsList.get(position).getData();
        holder.txtTitle.setText(redditDataModel.getTitle());
        Picasso.with(context).load(redditDataModel.getThumbnail()).into(holder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        if (redditsList == null) {
            return 0;
        }
        return redditsList.size();
    }

    public void reloadReddits() {
        redditDataService.getTopReddits().enqueue(new Callback<RedditDataModel>() {

            @Override
            public void onResponse(Call<RedditDataModel> call, Response<RedditDataModel> response) {
                RedditDataModel redditDataModel = response.body();
                redditsList = redditDataModel.getData().getChildren();
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RedditDataModel> call, Throwable t) {
                redditsList = new LinkedList<RedditDataModel>();
                notifyDataSetChanged();
            }
        });
    }
}
