package org.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.user.dto.UsersRequest;
import org.user.dto.UsersResponse;
import org.user.service.UsersManagementServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserManagementController {
  @Autowired UsersManagementServiceImpl userManagementServiceImpl;

  @PostMapping(
      path = "/api/v1/directory/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public UsersResponse addUser(@Valid @RequestBody UsersRequest request) {
    return userManagementServiceImpl.addUser(request);
  }

  @GetMapping(
      path = "/api/v1/directory/{userId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public UsersResponse searchUser(@PathVariable String userId) {
    return userManagementServiceImpl.searchUser(userId);
  }

  @DeleteMapping(
      path = "/api/v1/directory/{userId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public String deleteUser(@PathVariable String userId) {
    return userManagementServiceImpl.deleteUser(userId);
  }
}
