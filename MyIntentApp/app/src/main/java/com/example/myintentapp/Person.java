package com.example.myintentapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name;
    private int npm;
    private String email;
    private String city;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getNpm(){
        return npm;
    }
    public void setNpm(int npm){
        this.npm = npm;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.npm);
        dest.writeString(this.email);
        dest.writeString(this.city);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.npm = in.readInt();
        this.email = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
