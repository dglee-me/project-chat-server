package kr.co.ds.chat.service;

import jakarta.transaction.Transactional;
import kr.co.ds.chat.domain.user.dto.ChatUserDto;
import kr.co.ds.chat.entity.Authority;
import kr.co.ds.chat.entity.ChatUser;
import kr.co.ds.chat.exception.DuplicateMemberException;
import kr.co.ds.chat.exception.NotFoundMemberException;
import kr.co.ds.chat.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import org.slf4j.Logger;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ChatUserDto signup(ChatUserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByEmailId(userDto.getEmailId()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        ChatUser user = ChatUser.builder()
                .emailId(userDto.getEmailId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return ChatUserDto.from(userRepository.save(user));
    }

    @Transactional
    public ChatUserDto getUserWithAuthorities(String username) {
        return ChatUserDto.from(userRepository.findOneWithAuthoritiesByEmailId(username).orElse(null));
    }

    @Transactional
    public ChatUserDto getMyUserWithAuthorities() {
        return ChatUserDto.from(
                getCurrentUsername()
                        .flatMap(userRepository::findOneWithAuthoritiesByEmailId)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"))
        );
    }
    public static Optional<String> getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            logger.debug("Security Context에 인증 정보가 없습니다.");
            return Optional.empty();
        }

        String username = null;
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            username = springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            username = (String) authentication.getPrincipal();
        }

        return Optional.ofNullable(username);
    }
}
