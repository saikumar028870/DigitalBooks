package com.digitalbooks.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.demo.dto.AurthorDto;
import com.digitalbooks.demo.dto.AurthorSignUpDto;
import com.digitalbooks.demo.entity.Aurthor;
import com.digitalbooks.demo.repository.AurthorRepository;
import com.digitalbooks.demo.service.AurthorService;

@Service
public class AurthorServiceImpl implements AurthorService {

	@Autowired
	AurthorRepository aurthorRepository;

	@Override
	public void registerAurthor(AurthorSignUpDto AurthorSignUpDto) throws Exception {
		// Let's check if user already registered with us
		if (checkIfUserExist(AurthorSignUpDto.getEmail())) {
			throw new Exception("User already exists for this email");
		}
		Aurthor aurthor = new Aurthor();
		aurthor.setEmail(AurthorSignUpDto.getEmail());
		aurthor.setFirstName(AurthorSignUpDto.getFirstName());
		aurthor.setLastName(AurthorSignUpDto.getLastName());
		aurthor.setPassword(AurthorSignUpDto.getPassword());
		aurthor.setLoggedin(true);
		aurthorRepository.save(aurthor);

	}

	@Override
	public boolean checkIfUserExist(String emailId) {
		boolean response;
		Optional<Aurthor> aurthorOptional = aurthorRepository.findByEmail(emailId);
		if (aurthorOptional.isPresent()) {
			response = true;
		} else {
			response = false;
		}
		return response;
	}

	@Override
	public String aurthorLoggedIn(AurthorDto aurthorDto) {
		String response = "";
		Optional<Aurthor> aurthorOptional = aurthorRepository.findByEmail(aurthorDto.getEmail());
		if (aurthorOptional.isPresent()) {
			Aurthor Aurthor = aurthorOptional.get();
			response = Aurthor.getFirstName() + " logged in Succefully";
			Aurthor.setLoggedin(true);
			aurthorRepository.save(Aurthor);
		} else {
			response = "aurthor logged in failed";
		}
		return response;
	}

	@Override
	public String aurthorLoggedOut(AurthorDto aurthorDto) {
		String response = "";
		Optional<Aurthor> aurthorOptional = aurthorRepository.findByEmail(aurthorDto.getEmail());
		if (aurthorOptional.isPresent()) {
			Aurthor Aurthor = aurthorOptional.get();
			response = Aurthor.getFirstName() + " logged out Succefully";
			Aurthor.setLoggedin(true);
			aurthorRepository.save(Aurthor);
		} else {
			response = "aurthor logged out failed";
		}
		return response;
	}

}
