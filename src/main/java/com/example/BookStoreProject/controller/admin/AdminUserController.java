package com.example.BookStoreProject.controller.admin;

import com.example.BookStoreProject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminUserController {
    private final AdminService adminService;

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('admin:delete')")
    ResponseEntity<HttpStatus> deleteUser(@RequestParam(value = "userId") Long userId){
        adminService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
