package tech.toffu.business_web_app_project.services;

import tech.toffu.business_web_app_project.DTO.UserResgistrationDTO;
import tech.toffu.business_web_app_project.models.User;

public interface UserService {
	User save(UserResgistrationDTO resgisterationDTO);
}
