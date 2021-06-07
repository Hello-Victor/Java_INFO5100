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
public class Sai {
    private String bName;
    private int BRNumber;
    private int ANumber; 
    private double balance;
    private String AType;

    public Sai(String bName, int BRNumber, int ANumber, double balance, String AType) {
        this.bName = bName;
        this.BRNumber = BRNumber;
        this.ANumber = ANumber;
        this.balance = balance;
        this.AType = AType;
    }

    public Sai() {
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getBRNumber() {
        return BRNumber;
    }

    public void setBRNumber(int BRNumber) {
        this.BRNumber = BRNumber;
    }

    public int getANumber() {
        return ANumber;
    }

    public void setANumber(int ANumber) {
        this.ANumber = ANumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAType() {
        return AType;
    }

    public void setAType(String AType) {
        this.AType = AType;
    }
    
    
}
