package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.AuthenticationDtoRequest;
import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.AuthenticationDtoResponse;
import com.example.BookStoreProject.module.ResetPassword;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.service.JWTService;
import com.example.BookStoreProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserResetPasswordService userResetPasswordService;
    private final JWTService jwtService;
    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) {
        Authentication authObject;
        try {
            authObject = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (request.getEmail(),request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BadCredentialsException("Credentials Invalid");
        }
        String jwtToken = this.jwtToken(request);
        return AuthenticationDtoResponse
                .builder()
                .jwt(jwtToken)
                .build();
    }
    @Override
    public void changePassword(UserChangePasswordDtoRequest request, String token) {
        ResetPassword resetPassword = userResetPasswordService.getByToken(token);
        Users user = resetPassword.getUser();
        if(user != null){
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userService.save(user);
        }else{
            throw new RuntimeException("User not found");
        }
    }
    public String jwtToken(AuthenticationDtoRequest request){
        Users user = userService.getByUserEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        var jwt = jwtService.generateToken(user);
        return jwt;
    }
}
