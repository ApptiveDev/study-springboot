package com.hot6.pnureminder.repository;


import com.hot6.pnureminder.entity.Matching;
import com.hot6.pnureminder.entity.Matching_id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchingRepository extends JpaRepository<Matching, Matching_id> {

    Optional<Matching> findByMember1AndMember2(Long member1, Long member2);

}
