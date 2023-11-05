package com.hot6.pnureminder.repository;

import com.hot6.pnureminder.entity.Follow;
import com.hot6.pnureminder.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerMemberAndFollowingMember (Member followerMember, Member followingMember);
}
