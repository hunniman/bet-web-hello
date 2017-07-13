package com.bet.repository;

import com.bet.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {
    UserInfo findByUsername(String userName);
}
