package com.hot6.pnureminder.service;

import com.hot6.pnureminder.dto.followDto.FollowAddResponseDto;
import com.hot6.pnureminder.dto.followDto.FollowDto;
import com.hot6.pnureminder.dto.followDto.FollowListResponseDto;
import com.hot6.pnureminder.entity.Follow;
import com.hot6.pnureminder.entity.Member;
import com.hot6.pnureminder.repository.FollowRepository;
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
    private final FollowRepository followRepository;
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

        // 서로 팔로우가 안된 상태
        if(!isFollowing(followingMember, followerMember)) {
                 Follow follow = Follow.builder().followingMember(followingMember).
                                followerMember(followerMember).
                                build();
                 followingMember.getFollowingList().add(follow);
                 followerMember.getFollowerList().add(follow);
                System.out.println(followingMember.getFollowingList().size());
                 followRepository.save(follow);
        }



        if(canMatching(followerMember, followingMember)) {
            matchingService.createMatching(followerMember, followingMember);
        }
        return FollowAddResponseDto.builder().
                followerName(followerName).
                followingName(followingName).
                build();
    }

    public boolean canMatching(Member member1, Member member2) {

        Optional<Follow> follow1 = followRepository.findByFollowerMemberAndFollowingMember(member1, member2);
        Optional<Follow> follow2 = followRepository.findByFollowerMemberAndFollowingMember(member2, member1);

        return follow1.isPresent() && follow2.isPresent();
    }
    public FollowListResponseDto findFollowing(Member member) throws Exception{
        List<FollowDto> followDtoList1 = new ArrayList<>();
        List<Follow> followList = member.getFollowingList();
        if (followList == null){ throw new Exception("팔로우리스트가 비어있습니다");}
        for (Follow follow : followList) {
            followDtoList1.add(FollowDto.builder().
                    followingId(follow.getFollowingMember().getId()).
                    followerId(follow.getFollowerMember().getId())
                    .build());
        }
        FollowListResponseDto followListResponseDto = new FollowListResponseDto();
        return followListResponseDto.builder().followDtoList(followDtoList1).build();

    }

    public boolean isFollowing(Member followingMember, Member followerMember) {
        Optional<Follow> isFollowing = followRepository.findByFollowerMemberAndFollowingMember(followerMember, followingMember);
        return isFollowing.isPresent();
    }
}
