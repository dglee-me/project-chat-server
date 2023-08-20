package kr.co.ds.chat.domain.user.dto;

import lombok.*;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    private String emailId;

    @NotNull
    private String password;
}