package com.example.demo.services;

import com.example.demo.models.SinhVien;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public interface SinhVienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
}
