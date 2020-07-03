package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class SpuKey {
    private int id;
    private int spuId;
    private int specKeyId;

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

    public int getSpecKeyId() {
        return specKeyId;
    }

    public void setSpecKeyId(int specKeyId) {
        this.specKeyId = specKeyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpuKey spuKey = (SpuKey) o;
        return id == spuKey.id &&
                spuId == spuKey.spuId &&
                specKeyId == spuKey.specKeyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuId, specKeyId);
    }
}
