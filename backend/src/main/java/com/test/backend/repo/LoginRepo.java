package com.test.backend.repo;

import com.test.backend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {

    @Query(value = "select * from login where user_name=?1",nativeQuery = true)
    Login findByUserName(String userName);
}
