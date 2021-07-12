/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Department;

import model.College.College;
import model.Persona.Profile;

/**
 *
 * @author aeloyq
 */
public class DepartmentProfile extends Profile {

    String collegeName;
    String departmentName;
    College college;
    Department department;

    public DepartmentProfile(Department department) {
        this.college=department.getCollege();
        this.department=department;
        this.collegeName = college.getName();
        this.departmentName = department.getName();
    }

    public College getCollege() {
        return college;
    }

    public Department getDepartment() {
        return department;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

}
