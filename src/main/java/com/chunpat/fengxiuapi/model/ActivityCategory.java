package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class ActivityCategory {
    private int id;
    private int categoryId;
    private int activityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityCategory that = (ActivityCategory) o;
        return id == that.id &&
                categoryId == that.categoryId &&
                activityId == that.activityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, activityId);
    }
}
