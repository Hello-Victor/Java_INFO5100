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
public class RescueRequest extends WorkRequest {

    private HospitalRequest hospitalRequest;

    public RescueRequest() {
        super();
    }

    public HospitalRequest getHospitalRequest() {
        return hospitalRequest;
    }

    public void setHospitalRequest(HospitalRequest hospitalRequest) {
        this.hospitalRequest = hospitalRequest;
    }

}
