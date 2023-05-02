package com.example.networking;

public class Mountain {

    private String name;
    private String location;
    private int height;

    public Mountain (String n, String l, int h)
    {
        name=n;
        location=l;
        height=h;
    }

    public String info()
    {
        String tmp= new String();
        tmp+=name+location+height;
        return tmp;
    }

    public void setName (String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
}
