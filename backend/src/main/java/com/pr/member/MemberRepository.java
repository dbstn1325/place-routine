package com.pr.member;

import com.pr.member.domain.Member;
import com.pr.member.exception.NoSuchMemberException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(final String email);

    boolean existsByEmail(final String email);

    default Member getById(final Long id) {
        return findById(id)
                .orElseThrow(NoSuchMemberException::new);
    }

    default Member getByEmail(final String email) {
        return findByEmail(email)
                .orElseThrow(NoSuchMemberException::new);

    }
}
