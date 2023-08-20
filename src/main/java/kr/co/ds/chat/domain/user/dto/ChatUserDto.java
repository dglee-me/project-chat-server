package kr.co.ds.chat.domain.user.dto;

import kr.co.ds.chat.entity.ChatUser;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatUserDto {
    private String emailId;

    private String password;

    private String nickname;

    private Set<AuthorityDto> authorityDtoSet;

    public static ChatUserDto from(ChatUser user) {
        if (user == null) return null;

        return ChatUserDto.builder()
                .emailId(user.getEmailId())
                .nickname(user.getNickname())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}


