package com.example.BookStoreProject.controller.manager;

import com.example.BookStoreProject.dto.request.manager.publisher.PublisherUpdateNameDtoRequest;
import com.example.BookStoreProject.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/management/publisher")
@RequiredArgsConstructor
public class ManagerPublisherController {
    private final PublisherService publisherService;
    @PutMapping("/update/name")
    ResponseEntity<HttpStatus> updatePublisherName(@RequestBody PublisherUpdateNameDtoRequest request, Principal principal){
        publisherService.updatePublisherName(principal,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
