package thiGK.ntuMSSV.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import thiGK.ntuMSSV.Models.SinhVien;

@Service
public class SinhVienService {
	
	public static List<SinhVien> dsSinhViens() {
        List<SinhVien> danhSachSinhVien = new ArrayList<>();

        SinhVien sv1 = new SinhVien("SV001", "Trần Hoàng Trọng", 10.0f);
        SinhVien sv2 = new SinhVien("SV002", "Nguyễn Quốc Thái", 7.5f);
        SinhVien sv3 = new SinhVien("SV003", "Huỳnh Anh Vũ", 8.2f);

        danhSachSinhVien.add(sv1);
        danhSachSinhVien.add(sv2);
        danhSachSinhVien.add(sv3);

        return danhSachSinhVien;
    }
	
	public static SinhVien timKiemSinhVien(String maSinhVien) {
        List<SinhVien> danhSachSinhVien = dsSinhViens();
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMaSV().equals(maSinhVien)) {
                return sv;
            }
        }
        return null;
    }
	
	public static void themMoiSinhVien(SinhVien sinhVien) {
        List<SinhVien> danhSachSinhVien = dsSinhViens();
        danhSachSinhVien.add(sinhVien);
    }
    

}
