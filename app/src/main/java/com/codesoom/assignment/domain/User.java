package com.codesoom.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User Entity 클래스
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String name;

    private String password;

    /**
     * 비밀번호를 암호화한다.
     *
     * @param password 암호화 할 비밀번호
     * @param passwordEncoder 암호화에 사용할 인코더
     */
    public void encodePassword(String password,
                               PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    /**
     * 비밀번호 인증에 성공하면 true를 반환한다.
     *
     * @param password 인증할 비밀번호
     * @param passwordEncoder 인증에 사용할 인코더
     * @return 인증에 성공하면 true, 실패하면 false
     */
    public boolean authenticatePassword(String password,
                                        PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.password);
    }

    /**
     * User 정보를 수정한다.
     *
     * @param name 수정할 이름
     * @param email 수정할 이메일
     * @param password 수정할 비밀번호
     */
    public void update(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
