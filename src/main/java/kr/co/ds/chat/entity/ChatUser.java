package kr.co.ds.chat.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chatuser")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatUser {
    @Id
    @Column(name = "user_uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUid;

    @Column(name = "email_id", length = 50, unique = true)
    private String emailId;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_uid", referencedColumnName = "user_uid")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
