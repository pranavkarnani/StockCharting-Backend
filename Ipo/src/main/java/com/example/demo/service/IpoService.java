package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Ipo;
import com.example.demo.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IpoService {
	@Autowired
	IpoRepository ipoRepository;
	
	public List<Ipo> getIpo(){
		return (List<Ipo>) ipoRepository.findAll();
	}
	
	public void saveIpo(Ipo ipo) {
		ipoRepository.save(ipo);
	}

	@Transactional
	public Optional<Ipo> getByIpoId(Long id) {
		return ipoRepository.findById(id);
	}

	@Transactional
	public boolean updateIpo(Ipo ipo) {
		return ipoRepository.save(ipo) != null;
	}
}
