package tech.toffu.business_web_app_project.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import tech.toffu.business_web_app_project.DTO.UserResgistrationDTO;
import tech.toffu.business_web_app_project.models.Role;
import tech.toffu.business_web_app_project.models.User;
import tech.toffu.business_web_app_project.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userRepository;

	public UserServiceImp(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserResgistrationDTO resgisterationDTO) {
		User user = new User(resgisterationDTO.getFirstName(), resgisterationDTO.getLastName(),
				resgisterationDTO.getEmail(), resgisterationDTO.getPassword(), Arrays.asList(new Role("Role_User")));
		return userRepository.save(user);
	}

}
