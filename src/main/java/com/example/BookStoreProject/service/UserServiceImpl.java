package com.example.BookStoreProject.service;

import com.example.BookStoreProject.dto.request.user.UserChangeAddressRequest;
import com.example.BookStoreProject.dto.request.user.UserChangeEmailDtoRequest;
import com.example.BookStoreProject.dto.response.users.UserPreviousOrdersDtoResponse;
import com.example.BookStoreProject.module.Orders;
import com.example.BookStoreProject.module.Users;
import com.example.BookStoreProject.repository.UserResetPasswordRepository;
import com.example.BookStoreProject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        List<Orders> previous = user.getOrders();

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
    public Users save(Users user){
        return usersRepository.save(user);
    }

    @Override
    public void changeUserEmail(Principal principal, UserChangeEmailDtoRequest request) {
        Users user = this.getByUserEmail(principal.getName()).orElseThrow(()->
                new UsernameNotFoundException("Username not found"));
        try {
            user.setEmail(request.getNewEmail());
            this.save(user);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("User email change exception");
        }
    }

    @Override
    public void changeUserAddress(Principal principal, UserChangeAddressRequest request) {
        Users user = this.getByUserEmail(principal.getName()).orElseThrow(()->new UsernameNotFoundException("user not found"));
        try {
            user.setAddress(request.getNewAddress());
            this.save(user);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("User change address Exception");
        }
    }
}

