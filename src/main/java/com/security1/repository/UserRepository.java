package com.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security1.model.User;

// CRUD 함수를 JpaRepository가 들고있음
// @Repository 어노테이션이 없어도 IoC됨 왜냐하면 JpaRepository를 상속하면 자동 컴포넌트 스캔됨. 필요한곳에 @Autowired 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserid(String userid);
}