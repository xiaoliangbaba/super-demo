package com.my.tool.bo;

import java.util.List;

/**
 * Created by lilianga on 2018/12/4.
 */
public class CategoryInfoBO {
    public Long districtId;
    public String districtName;
    public Long cityId;
    public Long categoryId;
    public String categoryCode;
    public String categoryName;
    public String brief;
    public String introduction;
    public String imageId;
    public Long modifiedRank;
    public Integer channelType;
    public String categoryTags;
    public String sourceFrom;
    public List<CategoryPoiBO> categoryPoiList;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Long getModifiedRank() {
        return modifiedRank;
    }

    public void setModifiedRank(Long modifiedRank) {
        this.modifiedRank = modifiedRank;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(String categoryTags) {
        this.categoryTags = categoryTags;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public List<CategoryPoiBO> getCategoryPoiList() {
        return categoryPoiList;
    }

    public void setCategoryPoiList(List<CategoryPoiBO> categoryPoiList) {
        this.categoryPoiList = categoryPoiList;
    }
}
