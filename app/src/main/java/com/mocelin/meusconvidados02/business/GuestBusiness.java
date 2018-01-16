package com.mocelin.meusconvidados02.business;

import android.content.Context;

import com.mocelin.meusconvidados02.constants.DataBaseConstants;
import com.mocelin.meusconvidados02.entities.GuestEntity;
import com.mocelin.meusconvidados02.repository.GuestRepository;

import java.util.List;

/**
 * Created by mocelin on 09/01/2018.
 */

public class GuestBusiness {

    private GuestRepository mGuestRepository;
    private List<GuestEntity> invited;

    public GuestBusiness(Context context) {
        this.mGuestRepository = GuestRepository.getInstance(context);
    }

    public Boolean insert(GuestEntity guestEntity) {
        return this.mGuestRepository.insert(guestEntity);
    }

    public List<GuestEntity> getInvited() {
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME);
    }

    public GuestEntity load(int mGuestId) {
        return this.mGuestRepository.load(mGuestId);
    }
}
