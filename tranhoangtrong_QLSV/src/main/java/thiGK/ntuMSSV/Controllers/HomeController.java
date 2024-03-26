package thiGK.ntuMSSV.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import thiGK.ntuMSSV.Services.SinhVienService;

import thiGK.ntuMSSV.Models.SinhVien;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {		
		return "index";
	}
	
	@Autowired 
	private SinhVienService sinhVienService;
	@GetMapping("/sinhvien")
	public String sinhVien(Model model) {
		List<SinhVien> danhSachSinhVien = sinhVienService.dsSinhViens();
        model.addAttribute("danhSachSinhVien", danhSachSinhVien);        
		return "sinhvien";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		SinhVien sinhVien = new SinhVien();
        model.addAttribute("sinhVien", sinhVien);
		return "add";
	}
	
	@RequestMapping("/addSV")
    public String addSV(Model model, @ModelAttribute("sinhVien") SinhVien sinhVien) {
        SinhVienService.themMoiSinhVien(sinhVien);
        return "redirect:/";
    }
}



