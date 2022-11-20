package com.hungvi.omlab.activity.repository;

import com.hungvi.omlab.activity.entity.ActivityHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityHistoryRepository extends JpaRepository<ActivityHistoryEntity, Integer> {
}
