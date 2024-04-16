package com.example.qlbh_jpa_demo.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity // đánh dấu rằng đây là một entity
@Table(name = "khachhang") // chỉ định tên của bảng trong cơ sở dữ liệu.
public class Customer { // Tên lớp ta viết hoa chữ cái đầu
    // ----cho cột id-----------------------------------------------------------
    @Id // đánh dấu trường id là khóa chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // xác định cách khóa chính được sinh ra (ở đây là tự động tăng).
    @Column(name = "MAKH") // ánh xạ cột id của Bảng và thuộc tính id của Entiy
    private int id;

    // ----cho cột name-----------------------------------------------------------
    @Column(name = "HOTEN") // cột của Bảng customer
    private String name; // thuộc tính của Entity Customer
    // ----cho cột
    // address-----------------------------------------------------------
    @Column(name = "DCHI")
    private String address;

    @Column(name = "SDT")
    private String contactNumber;

    @Column(name = "NGSINH")
    private Date birthDate;

    @Column(name = "NGDK")
    private Date registerDate;

    @Column(name = "DOANHSO")
    private String doanhSo;

    // Constructors
    public Customer() {
    }

    public Customer(String name, String address, String contactNumber, Date birthDate, Date registerDate,
            String doanhSo) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.doanhSo = doanhSo;
    }

    // getters, setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(String doanhSo) {
        this.doanhSo = doanhSo;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Customer [address=" + address + ", birthDate=" + birthDate + ", contactNumber=" + contactNumber
                + ", doanhSo=" + doanhSo + ", id=" + id + ", name=" + name + ", registerDate=" + registerDate + "]";
    }
}
