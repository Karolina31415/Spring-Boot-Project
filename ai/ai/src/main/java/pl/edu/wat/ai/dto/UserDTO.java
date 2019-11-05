package pl.edu.wat.ai.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer idUser;
    private String username;
    private String email;
    private String password;

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
