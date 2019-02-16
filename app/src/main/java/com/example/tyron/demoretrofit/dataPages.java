package com.example.tyron.demoretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyron on 15/02/2019.
 */

public class dataPages {
    private int id;

    @SerializedName("first_name")
    private String primerNombre;
    private String last_name;
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return primerNombre;
    }

    public void setFirst_name(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
