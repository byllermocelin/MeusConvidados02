package com.mocelin.meusconvidados02.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mocelin.meusconvidados02.R;
import com.mocelin.meusconvidados02.entities.GuestEntity;

/**
 * Created by mocelin.rm on 13/01/2018.
 */

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "GuestViewHolder";
    private TextView mTextName;

    public GuestViewHolder(View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    public void bindData(GuestEntity guestEntity) {
        this.mTextName.setText(guestEntity.getName());
        Log.d(TAG, "bindData: ");
    }
}
