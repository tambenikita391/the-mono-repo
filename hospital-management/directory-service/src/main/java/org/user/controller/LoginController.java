package org.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.user.dto.LoginRequest;
import org.user.dto.LoginResponse;
import org.user.service.LoginService;

@RestController
public class LoginController {
  @Autowired LoginService service;

  @PostMapping("/api/v1/directory/validate")
  public LoginResponse usersLogin(@RequestBody LoginRequest request) throws Exception {
    return service.validateUser(request);
  }
}
