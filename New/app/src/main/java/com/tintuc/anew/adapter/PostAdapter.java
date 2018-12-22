package com.tintuc.anew.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tintuc.anew.R;

public class PostAdapter extends RecyclerView.Adapter {
    public PostAdapter(){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post,null);
        PostViewHolder postViewHolder = new PostViewHolder(v);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

    }

    private class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView imgThumb;
        TextView tvTitle;
        TextView tvDesc;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumb = (ImageView)itemView.findViewById(R.id.img_thumb);
            tvTitle = ( TextView)itemView.findViewById(R.id.tv_title);
            tvDesc = ( TextView)itemView.findViewById(R.id.tv_desc);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
