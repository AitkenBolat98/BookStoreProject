package com.example.BookStoreProject.service.authentication;

import com.example.BookStoreProject.dto.request.authentication.UserPasswordResetDtoRequest;
import com.example.BookStoreProject.dto.response.authentication.UserPasswordResetDtoResponse;
import com.example.BookStoreProject.module.ResetPassword;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UserResetPasswordRepository;
import com.example.BookStoreProject.service.EmailService;
import com.example.BookStoreProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.catalina.util.RequestUtil.getRequestURL;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserResetPasswordServiceImpl implements UserResetPasswordService{
    private final UserService userService;
    private final EmailService emailService;
    private final UserResetPasswordRepository userResetPasswordRepository;
    public ResetPassword save(ResetPassword instance){
        return userResetPasswordRepository.save(instance);
    }
    @Override
    public UserPasswordResetDtoResponse resetPassword(UserPasswordResetDtoRequest request) {
        Users user = userService.getByUserEmail(request.getEmail()).orElseThrow();
        String token = UUID.randomUUID().toString();
        String url = "http://localhost:8080/api/v1/auth/user/changepassword?token=" + token;
        this.createPasswordResetToken(user,token);
        emailService.sendEmail(user.getEmail(),"Password Reset",
                "Hello " + user.getName() + " click the link to reset your password " + url);
        return UserPasswordResetDtoResponse.builder()
                .message("Please follow the link in the email")
                .build();
    }
    public void createPasswordResetToken(Users user,String token){
        ResetPassword userToken = new ResetPassword();
        LocalDateTime sendTime = LocalDateTime.now();
        userToken.setUser(user);
        userToken.setToken(token);
        userToken.setExpirationDate(sendTime.plusDays(1));
        this.save(userToken);
    }
    public ResetPassword getByToken(String token){
        return userResetPasswordRepository.findByToken(token);
    }
    public boolean isValid(String token){
        LocalDateTime currentDate = LocalDateTime.now();
        ResetPassword userToken = this.getByToken(token);
        if(currentDate.isBefore(userToken.getExpirationDate()) && userToken.getToken().equals(token)){
            return true;
        }else{
            return false;
        }

    }
}
