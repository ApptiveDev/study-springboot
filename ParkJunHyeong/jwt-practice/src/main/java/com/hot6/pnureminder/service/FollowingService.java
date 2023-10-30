package com.hot6.pnureminder.service;

import com.hot6.pnureminder.dto.followDto.FollowAddResponseDto;
import com.hot6.pnureminder.dto.followDto.FollowDto;
import com.hot6.pnureminder.dto.followDto.FollowListResponseDto;
import com.hot6.pnureminder.entity.Member;
import com.hot6.pnureminder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FollowingService {

    private final MemberRepository memberRepository;
    private final MatchingService matchingService;

    // followerName = 팔로워 되는 member
    //followingName = 팔로윙 하는 member
    public FollowAddResponseDto addFollow(String followerName, String followingName) throws Exception {

        Optional<Member> follower = memberRepository.findByUsername(followerName);

        Optional<Member> following = memberRepository.findByUsername(followingName);
        if(follower.isEmpty()) {
            throw new Exception("follower멤버 없음");
        }
        if(following.isEmpty()) {
            throw new Exception("following멤버 없음");
        }

        Member followerMember = follower.get();
        Member followingMember = following.get();


        if (followerMember.getMemberFollower().getFollowerList() == null) {
            followerMember.getMemberFollower().getFollowerList().add(followingMember);
        }
        else if (!followerMember.getMemberFollower().getFollowerList().contains(followingMember)) {
            followerMember.getMemberFollower().getFollowerList().add(followingMember);
        }
        else {
            throw new Exception("이미 팔로우하고 있는 멤버입니다.");
        }

        if (followingMember.getMemberFollowing().getFollowingList() == null) {
            followingMember.getMemberFollowing().getFollowingList().add(followerMember);
        }
        else if (!followingMember.getMemberFollowing().getFollowingList().contains(followerMember)) {
            followingMember.getMemberFollowing().getFollowingList().add(followerMember);
        }
        else {
            throw new Exception("이미 팔로우하고 있는 멤버입니다.");
        }

        if(canMatcing(followerMember, followingMember)) {
            matchingService.createMatching(followerMember, followingMember);
        }
        return FollowAddResponseDto.builder().
                followerName(followerName).
                followingName(followingName).
                build();
    }

    public boolean canMatcing(Member member1, Member member2) {
        if(member1.getMemberFollowing().getFollowingList() == null || member2.getMemberFollowing().getFollowingList() == null) return false;
        if(member1.getMemberFollowing().getFollowingList().contains(member2) && member2.getMemberFollowing().getFollowingList().contains(member1)) {
            return true;
        }
        else return false;
    }
    public FollowListResponseDto findFollowing(Member member) throws Exception{
        List<FollowDto> followDtoList = new ArrayList<>();
        List<Member> followList = member.getFollowingList();
        if (followList == null){ throw new Exception("팔로우리스트가 비어있습니다");}
        for (Member followMember : followList) {
            followDtoList.add(FollowDto.builder().
                    userId(followMember.getId()).
                    userName(followMember.getUsername())
                    .build());
        }
        FollowListResponseDto followListResponseDto = new FollowListResponseDto();
        followListResponseDto.builder().followDtoList(followDtoList).build();
        return followListResponseDto;
    }
}
