package com.hungvi.omlab.activity.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "activity_history")
public class ActivityHistoryEntity {

    @Id
    @SequenceGenerator(name = "activity_history_id_seq", sequenceName = "activity_history_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_history_id_seq")
    private Integer id;
    private String action;
    private String tableName;
    private Integer recordId;
    private LocalDateTime createdAt;

}
