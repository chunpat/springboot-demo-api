package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class ThemeSpu {
    private int id;
    private int themeId;
    private int spuId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getSpuId() {
        return spuId;
    }

    public void setSpuId(int spuId) {
        this.spuId = spuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemeSpu themeSpu = (ThemeSpu) o;
        return id == themeSpu.id &&
                themeId == themeSpu.themeId &&
                spuId == themeSpu.spuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, themeId, spuId);
    }
}
