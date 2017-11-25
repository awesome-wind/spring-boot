package com.springboot.multi_resources.repository.work;

import com.springboot.multi_resources.entity.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work,Integer>{
}
