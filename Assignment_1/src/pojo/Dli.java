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
public class Dli {
    private int LNumber;
    private String uDate;
    private String eDate;
    private String bType;
    private String picture;

    public Dli(int LNumber, String uDate, String eDate, String bType, String picture) {
        this.LNumber = LNumber;
        this.uDate = uDate;
        this.eDate = eDate;
        this.bType = bType;
        this.picture = picture;
    }

    public Dli() {
    }

    public int getLNumber() {
        return LNumber;
    }

    public void setLNumber(int LNumber) {
        this.LNumber = LNumber;
    }

    public String getuDate() {
        return uDate;
    }

    public void setuDate(String uDate) {
        this.uDate = uDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
