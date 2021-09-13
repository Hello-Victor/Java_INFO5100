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
public class ElectricityRequest extends WorkRequest {

    private String decision;

    public ElectricityRequest() {
        super();
    }

    public String getDecision() {
        return decision == null ? "N/A" : decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

}
