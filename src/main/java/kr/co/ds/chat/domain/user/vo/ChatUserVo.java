package kr.co.ds.chat.domain.user.vo;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class ChatUserVo {
    public ChatUserVo(String emailId, String password, Collection<? extends GrantedAuthority> authorities) {
        this.emailId = emailId;
        this.password = password;
    }

    private String emailId;
    private String password;

}
