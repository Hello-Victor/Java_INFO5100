/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Role.EachFoodRecord;
import java.util.ArrayList;


/**
 *
 * @author aeloyq
 */
public class FoodRequest extends WorkRequest {

    private ArrayList<EachFoodRecord> foodRecord;
    private Integer foodRemain;

    public FoodRequest() {
        super();
        foodRecord = new ArrayList<>();
    }

    public int getFoodRemain() {
        return foodRemain;
    }

    public String getFoodRemainString() {
        return foodRemain == null ? "N/A" : String.valueOf(foodRemain);
    }

    public void setFoodRemain(int foodRemain) {
        this.foodRemain = foodRemain;
    }

    public ArrayList<EachFoodRecord> getFoodRecord() {
        return foodRecord;
    }

    public void setFoodRecord(ArrayList<EachFoodRecord> foodRecord) {
        this.foodRecord = foodRecord;
    }
    
    public EachFoodRecord addNewFeature(){
        EachFoodRecord f = new EachFoodRecord();
        foodRecord.add(f);
        f.setUserName("Null");
        f.setNumber(0);
        return f;
    }

}
