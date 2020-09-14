package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Optional<Activity> findByName(String name){
        return this.activityRepository.findByName(name);
    }
}
