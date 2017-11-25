package com.springboot.multi_resources.repository.user;


import com.springboot.multi_resources.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MyRepository extends JpaRepository<User,Integer>{

    @Modifying
    @Transactional
    @Query("update User u set u.userName=?1,u.password=?2,u.authority=?3,u.phone=?4 where u.id=?5")
    void modifyOne(String userName, String password, String authority, String phone, int id);
}
