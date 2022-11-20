package com.hungvi.omlab.common.model.event;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ActivityEvent {

    Action action;
    String tableName;
    Integer recordId;
    LocalDateTime createdAt;

}
