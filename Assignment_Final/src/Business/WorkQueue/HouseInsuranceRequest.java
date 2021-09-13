/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author aeloyq
 */
public class HouseInsuranceRequest extends WorkRequest {

    Integer loss;

    public HouseInsuranceRequest() {
        super();
    }

    public Integer getLoss() {
        return loss;
    }

    public String getLossString() {
        return loss == null ? "N/A" : String.valueOf(loss);
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

}
