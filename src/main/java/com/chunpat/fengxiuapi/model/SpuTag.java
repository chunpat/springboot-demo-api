package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class SpuTag {
    private int id;
    private int spuId;
    private int tagId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpuId() {
        return spuId;
    }

    public void setSpuId(int spuId) {
        this.spuId = spuId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpuTag spuTag = (SpuTag) o;
        return id == spuTag.id &&
                spuId == spuTag.spuId &&
                tagId == spuTag.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuId, tagId);
    }
}
