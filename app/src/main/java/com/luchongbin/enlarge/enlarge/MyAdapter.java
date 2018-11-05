package com.luchongbin.enlarge.enlarge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by luchongbin on 2018/11/5/005.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private String[] urls;
    private OnItemClickListener mListener;

    public MyAdapter(Context mContext, String[] urls) {
        this.mContext = mContext;
        this.urls = urls;
    }

    @Override
    public int getItemCount() {
        return urls != null && urls.length > 0 ? urls.length : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final String url = urls[position];
        Glide.with(mContext)
                .load(url)
                .placeholder(R.mipmap.ic_icon)
                .error(R.mipmap.ic_icon)
                .into(myViewHolder.ivIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(view,url);
            }
        });

    }

    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, String url);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

}
