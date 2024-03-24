package com.example.demo.Models;

public class DTOSinhVien {
	private String maSoSV;
	private String hoVaTen;
	//Getter and Setter
	public String getMaSoSV() {
		return maSoSV;
	}

	public void setMaSoSV(String maSoSV) {
		this.maSoSV = maSoSV;
	}
	
	public String getHoVaTen() {
		return hoVaTen;
	}
	
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	
	//Constructor
	public DTOSinhVien(String maSoSV, String hoVaTen) {
        this.maSoSV = maSoSV;
        this.hoVaTen = hoVaTen;
    }
	
	public DTOSinhVien() {
		super();
	}
}
