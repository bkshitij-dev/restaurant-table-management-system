package com.example.rtms.dto.response;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {

    private String token;
    private long expiresIn;
}
