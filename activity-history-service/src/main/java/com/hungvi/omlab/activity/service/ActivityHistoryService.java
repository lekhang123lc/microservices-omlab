package com.hungvi.omlab.activity.service;

import com.hungvi.omlab.common.model.event.ActivityEvent;

public interface ActivityHistoryService {

    void createActivityHistory(ActivityEvent event);

}
