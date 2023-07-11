package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.UserRegistrationDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.UserRegistrationDtoResponse;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UsersRepository usersRepository;

    private final JWTService jwtService;

    private final BCryptPasswordEncoder passwordEncoder;

    public Users save(Users user){
        return usersRepository.save(user);
    }

    @Override
    public UserRegistrationDtoResponse registration(UserRegistrationDtoRequest request) {
        var user = Users.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .name(request.getName())
                .build();
        this.save(user);
        var jwtToken = jwtService.generateToken(user);
        return UserRegistrationDtoResponse.builder()
                .email(user.getEmail())
                .address(user.getAddress())
                .jwt(jwtToken)
                .build();

    }

}
