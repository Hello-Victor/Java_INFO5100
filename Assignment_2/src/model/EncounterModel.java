/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author star
 */
public class EncounterModel {
    private Person person;
    private String timeNow;
    private String pulse;
    private String bloodPressure;
    private String temperature;
    private String spO2;
    private String community;
    private boolean abnormal;


    public EncounterModel() {
    }

    public EncounterModel(Person person, String timeNow, String pulse, String bloodPressure, String temperature, String spO2) {
        this.person = person;
        this.timeNow = timeNow;
        this.pulse = pulse;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.spO2 = spO2;
        this.community = person.getCommunity();
        int pulseInt = Integer.parseInt(pulse);
        int bloodPressureInt = Integer.parseInt(bloodPressure);
        int temperatureInt = Integer.parseInt(temperature);
        int spO2Int = Integer.parseInt(spO2);

        if ( pulseInt < 60 || pulseInt > 100){
            abnormal = true;
        } else if ( bloodPressureInt < 100 || bloodPressureInt > 120){
            abnormal = true;
        } else if ( temperatureInt < 36 || temperatureInt > 37){
            abnormal = true;
        } else if ( spO2Int < 94 || spO2Int > 100){
            abnormal = true;
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSpO2() {
        return spO2;
    }

    public void setSpO2(String spO2) {
        this.spO2 = spO2;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public boolean isAbnormal() {
        return abnormal;
    }

    public void setAbnormal(boolean abnormal) {
        this.abnormal = abnormal;
    }
}
