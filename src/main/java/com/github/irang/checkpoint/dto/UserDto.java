package com.github.irang.checkpoint.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String nickname;
}
