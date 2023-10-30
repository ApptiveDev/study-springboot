package com.hot6.pnureminder.dto.followDto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowListResponseDto {
    List<FollowDto> followDtoList = new ArrayList<>();
}
