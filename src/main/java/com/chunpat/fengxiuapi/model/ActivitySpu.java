package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class ActivitySpu {
    private int id;
    private int activityId;
    private int spuId;
    private Byte participation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getSpuId() {
        return spuId;
    }

    public void setSpuId(int spuId) {
        this.spuId = spuId;
    }

    public Byte getParticipation() {
        return participation;
    }

    public void setParticipation(Byte participation) {
        this.participation = participation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivitySpu that = (ActivitySpu) o;
        return id == that.id &&
                activityId == that.activityId &&
                spuId == that.spuId &&
                Objects.equals(participation, that.participation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityId, spuId, participation);
    }
}
