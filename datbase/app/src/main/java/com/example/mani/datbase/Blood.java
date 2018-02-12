package com.example.mani.datbase;

import java.util.zip.Inflater;

/**
 * Created by mani on 12-02-2018.
 */

public class Blood {


    private Integer id;
    private String name;
    private Integer sqlid;
    private String hostel;
    private String gender;
    private String bloodgroup;
    private String age;


    public Blood()
    {}
    public Blood(Integer id, String name, String hostel,String gender,String bloodgroup,String age)
    {
        this.id = id;
        this.name = name;
        this.hostel = hostel;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.age = age;
    }

    public Blood( String name, String hostel,String gender,String bloodgroup,String age)
    {
        this.name = name;
        this.hostel = hostel;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.age = age;
    }
    public Blood( String name, String hostel, String bloodgroup)
    {
        this.name = name;
        this.hostel = hostel;
        this.bloodgroup = bloodgroup;

    }
//    public Blood( String name, String Blood_type)
//    {
//        this.name = name;
//        this.Blood_type = Blood_type;
//    }

    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name = name;
    }

    public String getBloodgroup(){
        return bloodgroup;
    }
    public  void setBloodgroup(String bloodgroup){
        this.bloodgroup = bloodgroup;
    }

    public String getHostel(){
        return hostel;
    }
    public  void setHostel(String hostel){
        this.hostel = hostel;
    }
    public String getAge(){
        return age;
    }
    public  void setAge(String age){
        this.age = age;
    }
    public Integer getId(){
        return id;
    }
    public  void setId(Integer id){
        this.id = id;
    }

    public Integer getsqlId(){
        return sqlid;
    }
    public  void setsqlId(Integer id){
        this.sqlid = id;
    }
    public String getGender(){
        return gender;
    }
    public  void setGender(String gender){
        this.gender = gender;
    }


}
