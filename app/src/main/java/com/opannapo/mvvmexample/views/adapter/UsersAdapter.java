package com.opannapo.mvvmexample.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.mvvmexample.R;

import java.util.List;

/**
 * Created by napouser on 06,August,2020
 */
public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> data;
    private OnItemClicklListener listener;

    private static final int VIEW_TYPE_ITEM_ODD = 1;
    private static final int VIEW_TYPE_ITEM_EVEN = 2;

    public UsersAdapter(List<User> data, OnItemClicklListener listener) {
        this.listener = listener;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ITEM_ODD) {
            return new ViewHolderItemOdd(inflater.inflate(R.layout.view_item_user_odd, parent, false));
        } else {
            return new ViewHolderItemEven(inflater.inflate(R.layout.view_item_user_even, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderItemOdd) {
            ((ViewHolderItemOdd) holder).bind(data.get(position), listener);
        } else if (holder instanceof ViewHolderItemEven) {
            ((ViewHolderItemEven) holder).bind(data.get(position), listener);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? VIEW_TYPE_ITEM_EVEN : VIEW_TYPE_ITEM_ODD;
    }


    static class ViewHolderItemOdd extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgProfile;

        ViewHolderItemOdd(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imgProfile = itemView.findViewById(R.id.imgProfile);
        }

        void bind(final User u, final OnItemClicklListener listener) {
            Log.d("adapter live liveUsers user " + u);
            txtName.setText(u.getFirstName());
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition(), u);
                }
            });
        }
    }

    static class ViewHolderItemEven extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgProfile;

        ViewHolderItemEven(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imgProfile = itemView.findViewById(R.id.imgProfile);
        }

        void bind(final User u, final OnItemClicklListener listener) {
            txtName.setText(u.getFirstName());
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition(), u);
                }
            });
        }
    }

    public void notifyNoMoreData() {
        notifyItemChanged(getItemCount() - 1);
    }

    public void notifyAddMoreData(List<User> data) {
        this.data.addAll(data);
        this.notifyItemInserted(getItemCount() - 1);
    }

    public void notifyAddMoreData(User data) {
        this.data.add(data);
        this.notifyItemInserted(getItemCount() - 1);
    }

    public interface OnItemClicklListener {
        void onItemClick(int i, User user);
    }
}
