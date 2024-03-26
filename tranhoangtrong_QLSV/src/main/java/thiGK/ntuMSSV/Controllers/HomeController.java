package thiGK.ntuMSSV.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntuMSSV.Services.SinhVienService;

import thiGK.ntuMSSV.Models.SinhVien;

@Controller
public class HomeController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<SinhVien> danhSachSinhVien = sinhVienService.dsSinhViens();
        model.addAttribute("danhSachSinhVien", danhSachSinhVien);
		return "index";
	}
}
