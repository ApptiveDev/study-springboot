package com.hot6.pnureminder.controller;


import com.hot6.pnureminder.dto.followDto.FollowAddResponseDto;
import com.hot6.pnureminder.dto.followDto.FollowListResponseDto;
import com.hot6.pnureminder.entity.Member;
import com.hot6.pnureminder.repository.MemberRepository;
import com.hot6.pnureminder.service.FollowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowingService followingService;
    private final MemberRepository memberRepository;

    @PostMapping("/{followedId}")
    public ResponseEntity<FollowAddResponseDto> addFollow (@PathVariable Long followedId, Principal principal) throws Exception {
        Optional<Member> follwedMember = memberRepository.findById(followedId);
        String follwedUsername = follwedMember.get().getUsername();
        return ResponseEntity.ok(followingService.addFollow(follwedUsername, principal.getName()));
    }

    @GetMapping("/followingList")
    public ResponseEntity<FollowListResponseDto> findFollowing(Principal principal) throws Exception{
        Optional<Member> member = memberRepository.findByUsername(principal.getName());
        return ResponseEntity.ok(followingService.findFollowing(member.get()));
    }
}

