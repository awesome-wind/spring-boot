package com.spring.boot.repository;

import com.spring.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MyRepository extends JpaRepository<User,Integer>{

    @Modifying
    @Transactional
    @Query("update User u set u.userName=?1,u.password=?2,u.authority=?3,u.phone=?4 where u.id=?5")
    void modifyOne(String userName, String password, String authority, String phone, int id);
}
