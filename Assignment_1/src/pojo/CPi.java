/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Administrator
 */
public class CPi {
    private String fName;
    private String lName;
    private long pNumber;
    private String dBirth;
    private int age;
    private double height;
    private double weidth;
    private long ssNumber;

    public CPi(String fName, String lName, long pNumber, String dBirth, int age, double height, double weidth, long ssNumber) {
        this.fName = fName;
        this.lName = lName;
        this.pNumber = pNumber;
        this.dBirth = dBirth;
        this.age = age;
        this.height = height;
        this.weidth = weidth;
        this.ssNumber = ssNumber;
    }

    public CPi() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getpNumber() {
        return pNumber;
    }

    public void setpNumber(long pNumber) {
        this.pNumber = pNumber;
    }

    public String getdBirth() {
        return dBirth;
    }

    public void setdBirth(String dBirth) {
        this.dBirth = dBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeidth() {
        return weidth;
    }

    public void setWeidth(double weidth) {
        this.weidth = weidth;
    }

    public long getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(long ssNumber) {
        this.ssNumber = ssNumber;
    }
    
    
}
