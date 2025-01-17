package com.devid_academy.tutojava;

public class Country {
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

    public String getName() {
        return name;
    }
    public int getResId() {
        return resId;
    }

    public String getUrl() {
        return url;
    }
}
