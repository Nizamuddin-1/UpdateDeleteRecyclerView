package com.example.updatedeleterecyclerview;

public class Contact_Model {
    int img;
    String name,number;
    public Contact_Model(int img,String name,String number){
        this.img=img;
        this.name=name;
        this.number=number;
    }
    public Contact_Model(String name,String number){
        this.name=name;
        this.number=number;
    }
}
