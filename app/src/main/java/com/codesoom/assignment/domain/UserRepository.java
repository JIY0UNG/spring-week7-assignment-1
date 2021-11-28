package com.codesoom.assignment.domain;

import java.util.Optional;

/**
 * 회원 정보를 저장한다.
 */
public interface UserRepository {
    User save(User user);

    boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    Optional<User> findByIdAndDeletedIsFalse(Long id);

    Optional<User> findByEmail(String email);
}
