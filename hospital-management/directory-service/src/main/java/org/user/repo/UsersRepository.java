package org.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.user.entity.Users;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, String> {

  List<Users> findByUserId(String userId);

  String deleteByUserId(String userId);

  Users findByUserName(String userName);

  List<Users> findByUserNameAndMobileNumber(String userName, String mobileNumber);
}
