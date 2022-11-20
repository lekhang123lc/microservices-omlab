package com.hungvi.omlab.user.infras.config.kafka;

import com.hungvi.omlab.common.model.event.Action;
import com.hungvi.omlab.common.model.event.ActivityEvent;
import com.hungvi.omlab.user.model.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserEventProducer {
    @Value("${activityKafkaTopic}")
    private String activityKafkaTopic;

    private final static String TARGET = "user";

    private final KafkaTemplate<String, ActivityEvent> kafkaTemplate;

    public void publish(Action action, UserId userId) {
        ActivityEvent event = new ActivityEvent(action, TARGET, userId.toInt(), LocalDateTime.now());
        kafkaTemplate.send(activityKafkaTopic.toLowerCase(), event);
    }

}
