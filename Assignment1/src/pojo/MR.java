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
public class MR {
    private int MRNumber;
    private String ag1;
    private String ag2;
    private String ag3;

    public MR(int MRNumber, String ag1, String ag2, String ag3) {
        this.MRNumber = MRNumber;
        this.ag1 = ag1;
        this.ag2 = ag2;
        this.ag3 = ag3;
    }

    public MR() {
    }

    public int getMRNumber() {
        return MRNumber;
    }

    public void setMRNumber(int MRNumber) {
        this.MRNumber = MRNumber;
    }

    public String getAg1() {
        return ag1;
    }

    public void setAg1(String ag1) {
        this.ag1 = ag1;
    }

    public String getAg2() {
        return ag2;
    }

    public void setAg2(String ag2) {
        this.ag2 = ag2;
    }

    public String getAg3() {
        return ag3;
    }

    public void setAg3(String ag3) {
        this.ag3 = ag3;
    }
    
    
}
