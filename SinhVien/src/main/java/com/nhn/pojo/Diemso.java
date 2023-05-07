/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhn.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "diemso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diemso.findAll", query = "SELECT d FROM Diemso d"),
    @NamedQuery(name = "Diemso.findById", query = "SELECT d FROM Diemso d WHERE d.id = :id"),
    @NamedQuery(name = "Diemso.findByDiemgiuaky", query = "SELECT d FROM Diemso d WHERE d.diemgiuaky = :diemgiuaky"),
    @NamedQuery(name = "Diemso.findByDiemcuoiky", query = "SELECT d FROM Diemso d WHERE d.diemcuoiky = :diemcuoiky"),
    @NamedQuery(name = "Diemso.findByDiembosung1", query = "SELECT d FROM Diemso d WHERE d.diembosung1 = :diembosung1"),
    @NamedQuery(name = "Diemso.findByDiembosung2", query = "SELECT d FROM Diemso d WHERE d.diembosung2 = :diembosung2"),
    @NamedQuery(name = "Diemso.findByTrangthaikhoadiem", query = "SELECT d FROM Diemso d WHERE d.trangthaikhoadiem = :trangthaikhoadiem"),
    @NamedQuery(name = "Diemso.findByTrangthailuunhap", query = "SELECT d FROM Diemso d WHERE d.trangthailuunhap = :trangthailuunhap")})
public class Diemso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diemgiuaky")
    private double diemgiuaky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diemcuoiky")
    private double diemcuoiky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diembosung1")
    private double diembosung1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diembosung2")
    private double diembosung2;
    @Column(name = "trangthaikhoadiem")
    private Boolean trangthaikhoadiem;
    @Column(name = "trangthailuunhap")
    private Boolean trangthailuunhap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diemsoId")
    private Set<Monhoc> monhocSet;

    public Diemso() {
    }

    public Diemso(Integer id) {
        this.id = id;
    }

    public Diemso(Integer id, double diemgiuaky, double diemcuoiky, double diembosung1, double diembosung2) {
        this.id = id;
        this.diemgiuaky = diemgiuaky;
        this.diemcuoiky = diemcuoiky;
        this.diembosung1 = diembosung1;
        this.diembosung2 = diembosung2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDiemgiuaky() {
        return diemgiuaky;
    }

    public void setDiemgiuaky(double diemgiuaky) {
        this.diemgiuaky = diemgiuaky;
    }

    public double getDiemcuoiky() {
        return diemcuoiky;
    }

    public void setDiemcuoiky(double diemcuoiky) {
        this.diemcuoiky = diemcuoiky;
    }

    public double getDiembosung1() {
        return diembosung1;
    }

    public void setDiembosung1(double diembosung1) {
        this.diembosung1 = diembosung1;
    }

    public double getDiembosung2() {
        return diembosung2;
    }

    public void setDiembosung2(double diembosung2) {
        this.diembosung2 = diembosung2;
    }

    public Boolean getTrangthaikhoadiem() {
        return trangthaikhoadiem;
    }

    public void setTrangthaikhoadiem(Boolean trangthaikhoadiem) {
        this.trangthaikhoadiem = trangthaikhoadiem;
    }

    public Boolean getTrangthailuunhap() {
        return trangthailuunhap;
    }

    public void setTrangthailuunhap(Boolean trangthailuunhap) {
        this.trangthailuunhap = trangthailuunhap;
    }

    @XmlTransient
    public Set<Monhoc> getMonhocSet() {
        return monhocSet;
    }

    public void setMonhocSet(Set<Monhoc> monhocSet) {
        this.monhocSet = monhocSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diemso)) {
            return false;
        }
        Diemso other = (Diemso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhn.pojo.Diemso[ id=" + id + " ]";
    }
    
}
