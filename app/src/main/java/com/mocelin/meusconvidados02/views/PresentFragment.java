package com.mocelin.meusconvidados02.views;

import android.content.Context;
import android.content.Intent;
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
import com.mocelin.meusconvidados02.constants.GuestConstants;
import com.mocelin.meusconvidados02.entities.GuestEntity;
import com.mocelin.meusconvidados02.listener.OnGuestListenerInteractionListener;

import java.util.List;

public class PresentFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_present, container, false);
        Context context = view.getContext();

        // Obter recyclerView
        this.mViewHolder.mRecyclerAllPresent = view.findViewById(R.id.recycler_all_present);

        this.mGuestBusiness = new GuestBusiness(context);

        OnGuestListenerInteractionListener listener = new OnGuestListenerInteractionListener() {
            @Override
            public void onListClick(int id) {
                // abrir activity formulário
                Bundle bundle = new Bundle();
                bundle.putInt(GuestConstants.BundleConstants.GUEST_ID, id);

                Intent intent = new Intent(getContext(), GuestFormActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int id) {

            }
        };

        List<GuestEntity> guestEntityList = this.mGuestBusiness.getPresent();

        // Definir adapter
        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, listener);
        this.mViewHolder.mRecyclerAllPresent.setAdapter(guestListAdapter);

        //Definir layout
        this.mViewHolder.mRecyclerAllPresent.setLayoutManager(new LinearLayoutManager(context));


        return view;
    }

    private static class ViewHolder {
        private RecyclerView mRecyclerAllPresent;
    }

}
