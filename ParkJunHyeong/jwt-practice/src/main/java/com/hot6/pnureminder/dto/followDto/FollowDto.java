package com.hot6.pnureminder.dto.followDto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FollowDto {
    private Long followingId;
    private Long followerId;
}

