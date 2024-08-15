package org.user.service;

import org.user.dto.LoginRequest;
import org.user.dto.LoginResponse;

public interface LoginService {

  public LoginResponse validateUser(LoginRequest request) throws Exception;
}
