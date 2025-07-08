package com.practice._250708_springboot_practice_todolistdto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "ID를 입력하세요")
    private String username;
    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
