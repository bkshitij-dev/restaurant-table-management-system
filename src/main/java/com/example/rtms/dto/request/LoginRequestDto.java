package com.example.rtms.dto.request;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

import com.example.rtms.constant.AppConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotNull(message = "Email/Username cannot be null")
    @NotBlank(message = "Email/Username cannot be blank")
    private String emailOrUsername;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
