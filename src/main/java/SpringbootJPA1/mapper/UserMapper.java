package SpringbootJPA1.mapper;

import SpringbootJPA1.dto.CreateAccountResponseDTO;
import SpringbootJPA1.entity.User;

public class UserMapper {

	public UserMapper() { }
	
	public static CreateAccountResponseDTO createResponse(User user, String message) {
		CreateAccountResponseDTO dto = new CreateAccountResponseDTO();
		
		dto.setUsername(user.getUsername());
		dto.setRole(user.getRole());
		dto.setMessage(message);
		return dto;
	}
	
}
