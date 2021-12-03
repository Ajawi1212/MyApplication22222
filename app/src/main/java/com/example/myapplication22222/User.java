package com.example.myapplication22222;


enum ProfissionalCategory{
    Designer , Constractor , IronWorker , Titler , Painter , Carpenter , Plumber , Electrical , Worker ,
    Furniture , Kitchen , Cleaner , GardenWorker , Mechanical , InternetWorker;
}

public class User {

   private String FirstName;
   private String LastName;
   private int IdNum;
   private int CardNum;
   private String Location;

    public User(String firstName, String lastName, int idNum, int cardNum, String location) {
        FirstName = firstName;
        LastName = lastName;
        IdNum = idNum;
        CardNum = cardNum;
        Location = location;
    }

    public User(String name, String description, String address, UserCat valueOf, String photo, String phone) {
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getIdNum() {
        return IdNum;
    }

    public void setIdNum(int idNum) {
        IdNum = idNum;
    }

    public int getCardNum() {
        return CardNum;
    }

    public void setCardNum(int cardNum) {
        CardNum = cardNum;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", IdNum=" + IdNum +
                ", CardNum=" + CardNum +
                ", Location='" + Location + '\'' +
                '}';
    }
}
