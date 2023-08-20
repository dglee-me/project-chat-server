package kr.co.ds.chat.repository;


import kr.co.ds.chat.entity.ChatUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ChatUser, Long> {
    @EntityGraph(attributePaths = "authorities")
    Optional<ChatUser> findOneWithAuthoritiesByEmailId(String emailId);

}
