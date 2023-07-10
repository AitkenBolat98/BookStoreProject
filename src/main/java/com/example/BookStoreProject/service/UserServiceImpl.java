package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.user.UserChangePasswordDtoRequest;
import com.example.BookStoreProject.dto.response.users.UserChangePasswordDtoResponse;
import com.example.BookStoreProject.dto.response.users.UserPreviousOrdersDtoResponse;
import com.example.BookStoreProject.module.Orders;
import com.example.BookStoreProject.module.ResetPassword;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UserResetPasswordRepository;
import com.example.BookStoreProject.repository.UsersRepository;
import com.example.BookStoreProject.service.authentication.UserResetPasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final UserResetPasswordRepository userResetPasswordRepository;

    private final BCryptPasswordEncoder encoder;


    @Override
    public Optional<Users> getByUserEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> getById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public UserPreviousOrdersDtoResponse previousOrders(Principal principal) {

        Users user = usersRepository.findByEmail(principal.getName()).orElseThrow();
        System.out.println("GOOD!!");
        List<Orders> previous = user.getOrders();
        System.out.println("GOOD!!");

        UserPreviousOrdersDtoResponse userPreviousOrdersDtoResponse = new UserPreviousOrdersDtoResponse();
        userPreviousOrdersDtoResponse.setOrders(user.getOrders().get(0));
        return userPreviousOrdersDtoResponse;
    }

    @Override
    public void deleteUser(Principal principal) {
        Users user = usersRepository.findByEmail(principal.getName()).orElseThrow();
        try {
            usersRepository.delete(user);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("user delete exception");
        }
    }


    @Override
    public void changePassword(UserChangePasswordDtoRequest request, String token) {
        ResetPassword resetPassword = userResetPasswordRepository.findByToken(token);
        Users user = resetPassword.getUser();
        if(user != null){
            user.setPassword(encoder.encode(request.getNewPassword()));
            this.save(user);
        }else{
            throw new RuntimeException("User not found");
        }

    }
    public Users save(Users user){
        return usersRepository.save(user);
    }
}

