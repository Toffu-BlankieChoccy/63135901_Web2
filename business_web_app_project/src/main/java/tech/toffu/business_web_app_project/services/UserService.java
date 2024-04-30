package tech.toffu.business_web_app_project.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import tech.toffu.business_web_app_project.DTO.UserResgistrationDTO;
import tech.toffu.business_web_app_project.models.User;

public interface UserService extends UserDetailsService {
	User save(UserResgistrationDTO resgisterationDTO);
}
