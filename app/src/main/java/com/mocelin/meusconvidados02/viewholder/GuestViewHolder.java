package com.mocelin.meusconvidados02.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mocelin.meusconvidados02.R;

/**
 * Created by mocelin.rm on 13/01/2018.
 */

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;

    public GuestViewHolder(View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.tex_name);
    }
}
