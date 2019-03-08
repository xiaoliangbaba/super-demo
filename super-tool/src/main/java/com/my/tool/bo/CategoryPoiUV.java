package com.my.tool.bo;

/**
 * Created by lilianga on 2018/12/5.
 */
public class CategoryPoiUV {
    long poiId;
    int rank;
    String poiName;
    long districtId;
    long categoryId;
    String categoryName;
    long commentcount;
    float rating;
    long lastweekuv;
    long thisweekuv;

    long categoryuv;
    double proportion;//占比
    double growthRate;//增长率

    long totalCommentcount;
    double grade;
    double totalPoints;//总分
    int finalRank;

    public long getPoiId() {
        return poiId;
    }

    public void setPoiId(long poiId) {
        this.poiId = poiId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(long commentcount) {
        this.commentcount = commentcount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getLastweekuv() {
        return lastweekuv;
    }

    public void setLastweekuv(long lastweekuv) {
        this.lastweekuv = lastweekuv;
    }

    public long getThisweekuv() {
        return thisweekuv;
    }

    public void setThisweekuv(long thisweekuv) {
        this.thisweekuv = thisweekuv;
    }

    public long getCategoryuv() {
        return categoryuv;
    }

    public void setCategoryuv(long categoryuv) {
        this.categoryuv = categoryuv;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public long getTotalCommentcount() {
        return totalCommentcount;
    }

    public void setTotalCommentcount(long totalCommentcount) {
        this.totalCommentcount = totalCommentcount;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
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
