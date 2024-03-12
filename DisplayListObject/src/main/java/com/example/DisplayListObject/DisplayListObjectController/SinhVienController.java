package com.example.DisplayListObject.DisplayListObjectController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.DisplayListObject.DisplayListObjectController.DisplayListObjectModels.SinhVien;
@Controller
public class SinhVienController {
	// Ta hard-code dữ liệu tại đây  để tiện demo------ 
		static List<SinhVien> dsSinhVien=  new ArrayList<SinhVien>();
		static {
				dsSinhVien.add(new SinhVien("0001", "Trần Hoàng Trọng"));
				dsSinhVien.add(new SinhVien("0002", "Nhân Bản Của Trần Hoàng Trọng"));
			 }
		//----------hết phần hard-code dữ liệu ---------------------	
		@GetMapping("/danhsachSV")
		public String listStudent(ModelMap mm) {
		    mm.addAttribute("dsSV", dsSinhVien);
		    return "sinhvien_getAll";
		}
}
