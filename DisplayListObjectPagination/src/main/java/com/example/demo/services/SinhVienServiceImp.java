package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class SinhVienServiceImp implements SinhVienService{
	static List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static {
		dsSinhVien.add(new SinhVien("0001", "Co Siêu Tu"));
		dsSinhVien.add(new SinhVien("0002", "Co Siêu Tu"));
		dsSinhVien.add(new SinhVien("0003", "Co Siêu Tu"));
		dsSinhVien.add(new SinhVien("0004", "Trần Văn Long"));
		dsSinhVien.add(new SinhVien("0005", "Mai Cường Thọ"));
		dsSinhVien.add(new SinhVien("0006", "Trần Văn Long"));
		dsSinhVien.add(new SinhVien("0007", "Mai Cường Thọ"));
		dsSinhVien.add(new SinhVien("0008", "Trần Văn Long"));
		dsSinhVien.add(new SinhVien("0009", "Mai Cường Thọ"));
		dsSinhVien.add(new SinhVien("0010", "Trần Văn Long"));
		dsSinhVien.add(new SinhVien("0011", "Mai Cường Thọ"));
		dsSinhVien.add(new SinhVien("0012", "Trần Văn Long"));
	}
	//----------hết phần hard-code dữ liệu ---------------------
	
	@Override
	public Page<SinhVien> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<SinhVien> list;
		if (dsSinhVien.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, dsSinhVien.size());
			list = dsSinhVien.subList(startItem, toIndex);
		}
		Page<SinhVien> page = new PageImpl<SinhVien>(list, PageRequest.of(currentPage, pageSize), dsSinhVien.size());
		return page;
	}
}
