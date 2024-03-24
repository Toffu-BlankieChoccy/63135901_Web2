package com.example.demo.models;

public class SinhVien {
	private String maSoSinhVien;
	private String hoTen;
	
	//Getter and setter
	public String getMaSoSinhVien() {
		return maSoSinhVien;
	}

	public void setMaSoSinhVien(String maSoSinhVien) {
		this.maSoSinhVien = maSoSinhVien;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	//Constructor
	public SinhVien(String maSoSinhVien, String hoTen) {
		this.maSoSinhVien = maSoSinhVien;
		this.hoTen = hoTen;
	}
}
