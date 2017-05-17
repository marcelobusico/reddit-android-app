package com.busico.reddit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListRedditsViewHolder extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public ImageView imgThumbnail;

    public ListRedditsViewHolder(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        imgThumbnail = (ImageView) itemView.findViewById(R.id.imgThumbnail);
    }
}
