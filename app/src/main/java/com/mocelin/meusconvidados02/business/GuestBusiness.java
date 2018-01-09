package com.mocelin.meusconvidados02.business;

import android.content.Context;

import com.mocelin.meusconvidados02.entities.GuestEntity;
import com.mocelin.meusconvidados02.repository.GuestRepository;

/**
 * Created by mocelin on 09/01/2018.
 */

public class GuestBusiness {

    private GuestRepository mGuestRepository;

    public GuestBusiness(Context context) {
        this.mGuestRepository = GuestRepository.getInstance(context);
    }

    public Boolean insert(GuestEntity guestEntity) {
        return this.mGuestRepository.insert(guestEntity);
    }
}
