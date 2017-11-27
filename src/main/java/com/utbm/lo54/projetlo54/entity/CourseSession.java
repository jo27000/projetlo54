/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jdugard
 */
@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;

    @ManyToOne
    @JoinColumn(name = "COURSE_CODE", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", nullable = false)
    private Location location;

    public CourseSession() {
    }

    public CourseSession(Integer id, Calendar startDate, Calendar endDate, Course courseCode, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = courseCode;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "SessionCourse{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", courseCode=" + course + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.startDate);
        hash = 73 * hash + Objects.hashCode(this.endDate);
        hash = 73 * hash + Objects.hashCode(this.course);
        hash = 73 * hash + Objects.hashCode(this.location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CourseSession other = (CourseSession) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

}
