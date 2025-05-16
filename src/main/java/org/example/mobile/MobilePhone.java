package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    String myNumber;
    ArrayList<Contact> myContacts = new ArrayList<>();

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }
}
