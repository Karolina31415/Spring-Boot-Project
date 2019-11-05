package pl.edu.wat.ai.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewUserDTO {

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

}
