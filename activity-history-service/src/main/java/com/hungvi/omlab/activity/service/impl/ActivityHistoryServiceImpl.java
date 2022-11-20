package com.hungvi.omlab.activity.service.impl;

import com.hungvi.omlab.activity.entity.ActivityHistoryEntity;
import com.hungvi.omlab.activity.repository.ActivityHistoryRepository;
import com.hungvi.omlab.activity.service.ActivityHistoryService;
import com.hungvi.omlab.common.model.event.ActivityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityHistoryServiceImpl implements ActivityHistoryService {

    private final ActivityHistoryRepository activityHistoryRepository;

    @Override
    public void createActivityHistory(ActivityEvent event) {
        ActivityHistoryEntity activityHistory = convertToActivityHistory(event);
        activityHistoryRepository.save(activityHistory);
    }

    private ActivityHistoryEntity convertToActivityHistory(ActivityEvent event) {
        return ActivityHistoryEntity.builder()
                .action(event.getAction().toString())
                .tableName(event.getTableName())
                .recordId(event.getRecordId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
