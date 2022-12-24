package com.example.cardview;

public class ConnectModel {
    int img;
    String name,number;
//    Constructor
    public ConnectModel(int img, String name,String number){
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public ConnectModel(String name,String number){
        this.name = name;
        this.number = number;
    }
}
