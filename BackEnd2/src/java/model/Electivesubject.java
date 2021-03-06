/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "ELECTIVESUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electivesubject.findAll", query = "SELECT e FROM Electivesubject e"),
    @NamedQuery(name = "Electivesubject.findBySubjectid", query = "SELECT e FROM Electivesubject e WHERE e.subjectid = :subjectid"),
    @NamedQuery(name = "Electivesubject.findByRound1", query = "SELECT e FROM Electivesubject e WHERE e.round1 = 'yes'"),
    @NamedQuery(name = "Electivesubject.findByRound2", query = "SELECT e FROM Electivesubject e WHERE e.round2 = 'yes'"),
    @NamedQuery(name = "Electivesubject.findByName", query = "SELECT e FROM Electivesubject e WHERE e.name = :name"),
    @NamedQuery(name = "Electivesubject.findByDescription", query = "SELECT e FROM Electivesubject e WHERE e.description = :description")})
@SequenceGenerator(name = "ElESEQ", sequenceName = "elect_seq", allocationSize = 1)
public class Electivesubject implements Serializable {
    @Size(max = 5)
    @Column(name = "ROUND1")
    private String round1;
    @Size(max = 5)
    @Column(name = "ROUND2")
    private String round2;
    @JoinTable(name = "STUDENT_SUBJECT", joinColumns = {
        @JoinColumn(name = "SUBJECTID", referencedColumnName = "SUBJECTID")}, inverseJoinColumns = {
        @JoinColumn(name = "STUID", referencedColumnName = "STUID")})
    @ManyToMany
    private Collection<Student> studentCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECTID")
    @GeneratedValue(generator = "ElESEQ", strategy = GenerationType.IDENTITY)
    
    private Integer subjectid;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "POOL_SUBJECTS", joinColumns = {
        @JoinColumn(name = "SUBJECTID", referencedColumnName = "SUBJECTID")}, inverseJoinColumns = {
        @JoinColumn(name = "POOLNAME", referencedColumnName = "POOLNAME")})
    @ManyToMany
    private Collection<Pool> poolCollection;
    @JoinTable(name = "TEACHER_SUBJECT", joinColumns = {
        @JoinColumn(name = "SUBJECTID", referencedColumnName = "SUBJECTID")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHERID", referencedColumnName = "TEACHERID")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;

    public Electivesubject() {
    }

    //    public Electivesubject(Integer subjectid) {
    //        this.subjectid = subjectid;
    //    }
    
    public Electivesubject(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Electivesubject(Integer subjectid, String name, String description) {
        this.subjectid = subjectid;
        this.name = name;
        this.description = description;
    }

    public Electivesubject(String round1, String round2, Integer subjectid, String name) {
        this.round1 = round1;
        this.round2 = round2;
        this.subjectid = subjectid;
        this.name = name;
    }

    
    
    
    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Pool> getPoolCollection() {
        return poolCollection;
    }

    public void setPoolCollection(Collection<Pool> poolCollection) {
        this.poolCollection = poolCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectid != null ? subjectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electivesubject)) {
            return false;
        }
        Electivesubject other = (Electivesubject) object;
        if ((this.subjectid == null && other.subjectid != null) || (this.subjectid != null && !this.subjectid.equals(other.subjectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Electivesubject[ subjectid=" + subjectid + " ]";
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public String getRound1() {
        return round1;
    }

    public void setRound1(String round1) {
        this.round1 = round1;
    }

    public String getRound2() {
        return round2;
    }

    public void setRound2(String round2) {
        this.round2 = round2;
    }
    
}
