package thiGK.ntuMSSV.Models;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private float diemTichLuy;
	
	//getter and setter
	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	
	public String getTenSV() {
		return tenSV;
	}
	
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	
	public float getDiemTichLuy() {
		return diemTichLuy;
	}
	
	public void setDiemTichLuy(float diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	
	//Constructor
	public SinhVien(String maSV, String tenSV, float diemTichLuy) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.diemTichLuy = diemTichLuy;
	}
}
