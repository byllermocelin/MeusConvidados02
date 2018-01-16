package com.mocelin.meusconvidados02.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mocelin.meusconvidados02.R;
import com.mocelin.meusconvidados02.entities.GuestEntity;
import com.mocelin.meusconvidados02.listener.OnGuestListenerInteractionListener;

/**
 * Created by mocelin on 12/01/2018.
 */

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "GuestViewHolder";
    private TextView mTextName;

    public GuestViewHolder(View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    public void bindData(final GuestEntity guestEntity, final OnGuestListenerInteractionListener listener) {
        this.mTextName.setText(guestEntity.getName());
        Log.d(TAG, "bindData: ");

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListClick(guestEntity.getId());
            }
        });
    }
}
