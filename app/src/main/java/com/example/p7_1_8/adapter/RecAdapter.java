package com.example.p7_1_8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7_1_8.R;
import com.example.p7_1_8.model.UserBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecAdapter extends RecyclerView.Adapter {
    private ArrayList<UserBean.ResultsBean> list;
    private Context context;

    public RecAdapter(ArrayList<UserBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder v= (ViewHolder) holder;
        v.tvItem.setText(list.get(position).getWho());
        Glide.with(context).load(list.get(position).getUrl()).into(v.ivItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_item)
        ImageView ivItem;
        @BindView(R.id.tv_item)
        TextView tvItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
