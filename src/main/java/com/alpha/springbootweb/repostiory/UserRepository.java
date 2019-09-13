package com.alpha.springbootweb.repostiory;

import com.alpha.springbootweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);
    void deleteById(long id);

}
