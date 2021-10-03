package com.example.cvo;

public class QWE {
    private long id;
    private String time;
    private String str;


    public String getStr() {
        return str;
    }
    public String getTime() {
        return time;
    }
    public long getId() {
        return id;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return time.substring(5,16)+" "+id;
    }


}
