package com.example.myapplication22222;



public class UserClass {

    private String Name;
    private int IdNum;
    private int CardNum;
    private String Phone;
    private String Location;
}
    public UserClass(String Name, int idNum, int cardNum, String location, String Phone) {
        this.Name = Name;
        this.IdNum = idNum;
        this.CardNum = cardNum;
        this.Location = location;
        this.Phone = Phone;
    }
public String getName() {
    return Name;
}

public void setName() {
    Name=Name;
}
    public int getIdNum() {
        return IdNum;
    }
    public void setIdNum() {
        IdNum=IdNum;
}
    public int getCardNum() {
        return CardNum;
    }
    public void setCardNum() {
        CardNum=CardNum;
    }
    public String getPhone() {
        return Phone;
    }

    public void setPhone() { Phone=Phone;    }

    public String getLocation() {
        return Location;
    }
    public Void setLocation() {  Location =  Location; }











    @Override
    public String toString() {
        return "User{" +
                ", Name='" + Name + '\'' +
                ", IdNum=" + IdNum +
                ", Phone=" + Phone +
                ", CardNum=" + CardNum +
                ", Location='" + Location + '\'' +
                '}';
    }
}
