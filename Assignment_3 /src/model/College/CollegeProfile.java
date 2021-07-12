/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.College;

import model.Persona.Profile;

/**
 *
 * @author aeloyq
 */
public class CollegeProfile extends Profile {

    College college;
    String collegeName;

    public CollegeProfile(College college) {
        this.college = college;
        this.collegeName = college.getName();
    }

    public College getCollege() {
        return college;
    }

    public String getCollegeName() {
        return collegeName;
    }

}
