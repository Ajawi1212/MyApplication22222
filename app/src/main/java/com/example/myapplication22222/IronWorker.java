package com.example.myapplication22222;

public class IronWorker {

    private String Name;
    private int PhoneNum;

    public IronWorker(String name, int phoneNum) {
        Name = name;
        PhoneNum = phoneNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        PhoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "IronWorker{" +
                "Name='" + Name + '\'' +
                ", PhoneNum=" + PhoneNum +
                '}';
    }
}
