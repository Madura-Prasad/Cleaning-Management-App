package com.example.cleany.database;

public class houseOwner {

    private String Full_Name;
    private String Age;
    private String Mobile_number;
    private String Residence;
    private String Email;
    private String Password;
    private String Repeat_Password;

    public houseOwner(String full_Name, String age, String mobile_number, String residence, String email, String password, String repeat_Password) {
        Full_Name = full_Name;
        Age = age;
        Mobile_number = mobile_number;
        Residence = residence;
        Email = email;
        Password = password;
        Repeat_Password = repeat_Password;
    }

    public houseOwner() {
        Full_Name = "";
        Age = "";
        Mobile_number = "";
        Residence = "";
        Email = "";
        Password = "";
        Repeat_Password = "";

    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getMobile_number() {
        return Mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        Mobile_number = mobile_number;
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String residence) {
        Residence = residence;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRepeat_Password() {
        return Repeat_Password;
    }

    public void setRepeat_Password(String repeat_Password) {
        Repeat_Password = repeat_Password;
    }
}
