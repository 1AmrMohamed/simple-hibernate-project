package com.stock.entities;

public class User {

    private int usrId;
    private String usrFullName;
    private String email;
    private String usrName;
    private String password;

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getUsrFullName() {
        return usrFullName;
    }

    public void setUsrFullName(String usrFullName) {
        this.usrFullName = usrFullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
