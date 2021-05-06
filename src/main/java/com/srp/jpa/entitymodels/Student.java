package com.srp.jpa.entitymodels;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
@NamedQueries({
        @NamedQuery(name="getAllStudents", query = "select s from Student s"),
        @NamedQuery(name ="getStudentByEmail", query = "select s from Student s where s.sEmail = :email")
})
public class Student {

    /* FIELDS */
    @Id
    @Column(name = "email", nullable = false, length = 50) // Set NOT NULL and VARCHAR(50)
    private String sEmail;

    @Column(name = "name", nullable = false, length = 50)
    private String sName;

    @Column(name = "password", nullable = false, length = 50)
    private String sPass;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private List<Course> sCourses;


    /* CONSTRUCTORS */
    public Student() {
        sCourses = new ArrayList<>();
    }

    public Student(String sEmail, String sName, String sPass) {
        this();
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
    }


    /* GETTERS/SETTERS */
    public String getsEmail() {
        return sEmail;
    }

    /* Email should not be changed after creation as it is the primary key in the database.*/
/*    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }*/

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString() {
        return String.format("Student: %-50s | Email: %-50s | Password: %-50s", sName, sEmail, sPass);
    }
}
