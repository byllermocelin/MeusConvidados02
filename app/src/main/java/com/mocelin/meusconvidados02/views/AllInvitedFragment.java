package com.mocelin.meusconvidados02.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mocelin.meusconvidados02.R;
import com.mocelin.meusconvidados02.adapter.GuestListAdapter;
import com.mocelin.meusconvidados02.business.GuestBusiness;
import com.mocelin.meusconvidados02.entities.GuestEntity;

import java.util.List;


public class AllInvitedFragment extends Fragment {


    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_invited, container, false);
        Context context = view.getContext();

        // Obter recyclerView
        this.mViewHolder.mRecyclerAllInvited = view.findViewById(R.id.recycler_all_invited);

        this.mGuestBusiness = new GuestBusiness(context);
        List<GuestEntity> guestEntityList = this.mGuestBusiness.getInvited();

        // Definir adapter
        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList);
        this.mViewHolder.mRecyclerAllInvited.setAdapter(guestListAdapter);

        //Definir layout
        this.mViewHolder.mRecyclerAllInvited.setLayoutManager(new LinearLayoutManager(context));


        return view;
    }


    private static class ViewHolder {
        private RecyclerView mRecyclerAllInvited;
    }

}
