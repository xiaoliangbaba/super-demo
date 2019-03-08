package com.my.tool.bo;

/**
 * Created by lilianga on 2018/11/30.
 */
public class CategoryUV {
    long districtId;
    long categoryId;
    int modifiedRank;
    long lastWeekUV;
    long thisWeekUV;
    long totalUV;
    double growthRate;//增长率
    double proportion;//占比
    double totalPoints;//总分
    int finalRank;

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getModifiedRank() {
        return modifiedRank;
    }

    public void setModifiedRank(int modifiedRank) {
        this.modifiedRank = modifiedRank;
    }

    public long getLastWeekUV() {
        return lastWeekUV;
    }

    public void setLastWeekUV(long lastWeekUV) {
        this.lastWeekUV = lastWeekUV;
    }

    public long getThisWeekUV() {
        return thisWeekUV;
    }

    public void setThisWeekUV(long thisWeekUV) {
        this.thisWeekUV = thisWeekUV;
    }

    public long getTotalUV() {
        return totalUV;
    }

    public void setTotalUV(long totalUV) {
        this.totalUV = totalUV;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }
}
