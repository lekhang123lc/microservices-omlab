package com.hungvi.omlab.activity.infras.config.kafka;

import com.hungvi.omlab.activity.service.ActivityHistoryService;
import com.hungvi.omlab.common.model.event.ActivityEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaListeners {

    private final ActivityHistoryService activityHistoryService;


    @KafkaListener(topics = "${activityKafkaTopic}", groupId = "groupId", containerGroup = "messageFactory")
    void listener(ActivityEvent event) {
        log.debug("Event received: {}", event);
        activityHistoryService.createActivityHistory(event);
    }

}
