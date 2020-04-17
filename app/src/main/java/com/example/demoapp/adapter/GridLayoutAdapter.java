package com.example.demoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demoapp.R;
import com.example.demoapp.modal.DataMenu;

import java.util.List;

public class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.GridViewHolder> {

    private List<DataMenu> dataList;
    private boolean selectAll = false;
    private EventListener listener;

    public GridLayoutAdapter(List<DataMenu> dataList, boolean selectAll, EventListener listener) {
        this.dataList = dataList;
        this.selectAll = selectAll;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, final int position) {

        Glide.with(holder.imageView.getContext())
                .load(dataList.get(position).getCat_card())
                .into(holder.imageView);

        holder.tv_title.setText(dataList.get(position).getTitle());

        //Select All
        if(selectAll) {
            holder.mycheckbox.setChecked(true);
        }else {
            holder.mycheckbox.setChecked(false);
        }

        // For Multi Selection
        holder.ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onEvent(position);

               if (holder.mycheckbox.isChecked()){
                   holder.mycheckbox.setChecked(false);
               }else {
                   holder.mycheckbox.setChecked(true);
               }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }

    static class GridViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout ll_parent;
        CheckBox mycheckbox;
        ImageView imageView;
        TextView tv_title;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_parent = itemView.findViewById(R.id.parent);
            mycheckbox = itemView.findViewById(R.id.mycheckbox);
            imageView = itemView.findViewById(R.id.imageView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
    public interface EventListener{
        void onEvent(int position);
    }
}
