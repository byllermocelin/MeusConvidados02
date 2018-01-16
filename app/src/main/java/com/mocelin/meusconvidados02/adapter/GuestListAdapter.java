package com.mocelin.meusconvidados02.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mocelin.meusconvidados02.R;
import com.mocelin.meusconvidados02.entities.GuestEntity;
import com.mocelin.meusconvidados02.viewholder.GuestViewHolder;

import java.util.List;

/**
 * Created by mocelin on 12/01/2018.
 */

public class GuestListAdapter extends RecyclerView.Adapter<GuestViewHolder> {

    private static final String TAG = "GuestListAdapter";
    private List<GuestEntity> mGuestEntityList;

    public GuestListAdapter(List<GuestEntity> guestEntity) {
        this.mGuestEntityList = guestEntity;
    }

    @Override
    public GuestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewGuest = layoutInflater.inflate(R.layout.row_guest_list, parent, false);

        return new GuestViewHolder(viewGuest);
    }

    @Override
    public void onBindViewHolder(GuestViewHolder holder, int position) {
        GuestEntity guestEntity = this.mGuestEntityList.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        Log.i(TAG, "onBindViewHolder: ");
        holder.bindData(guestEntity);
    }

    @Override
    public int getItemCount() {
        return this.mGuestEntityList.size();
    }
}
