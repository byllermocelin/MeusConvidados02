package com.mocelin.meusconvidados02.entities;

/**
 * Created by mocelin on 09/01/2018.
 */

public class GuestEntity {

    private int id;
    private String name;
    private int confirmed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }
}
