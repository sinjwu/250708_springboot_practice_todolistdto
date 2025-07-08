package com.practice._250708_springboot_practice_todolistdto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

@Getter
@Setter
public class SignupDTO {
    @NotBlank(message = "ID를 입력하세요")
    @Size(min=6, max=255, message = "ID는 3~255자여야 합니다.")
    private String username;
    @NotBlank(message = "비밀번호를 입력하세요")
    @Size(min=6, max=255, message = "비밀번호는 3~255자여야 합니다.")
    private String password;
}
