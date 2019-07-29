package com.android.mor_arye.android5777_8159_8300.Model.Entities;

/**
 * Created by mor on 23  2016.
 */

public class User {
    private static int currentID = 1;
    private int idUser;
    private String nameUser;
    private String password;

    public User(String nameUser, String password) {
        this.idUser = currentID++;
        this.nameUser = nameUser;
        this.password = password;
    }

    //<editor-fold desc="geters and seters">
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

}
