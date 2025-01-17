package com.devid_academy.tutojava;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Country implements Parcelable {
    private String name;
    private int resId;

    private String url;
    public Country(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public Country(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Country(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public Country(){}

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getName() {
        return name;
    }
    public int getResId() {
        return resId;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url);
    }
}
