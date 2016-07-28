package com.androidclass.activitydatahandling;


import android.os.Parcel;
import android.os.Parcelable;

public class Fruit implements Parcelable {

    String name;
    int qty;
    String color;


    // Parcelling methods

    public Fruit(Parcel in) {

        this.name = in.readString();
        this.qty = in.readInt();
        this.color = in.readString();
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.qty);
        dest.writeString(this.color);

    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };


    public Fruit() {

    }

    public Fruit(String name, String color, int qty) {
        this.name = name;
        this.color = color;
        this.qty = qty;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit [name=" + name + ", qty=" + qty + ", color=" + color
                + "]";
    }

}
