package bot.model.amap;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hui
 * @since 2024-01-09 10:03:21
 */
public class Geocode {
    @JsonProperty("formatted_address")
    private String formattedAddress;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private Object district;
    /**
     * 城市编码
     */
    @JsonProperty("citycode")
    private String cityCode;
    /**
     * 区域编码
     */
    @JsonProperty("adcode")
    private String adCode;
    /**
     * 坐标点
     */
    private String location;
    /**
     * 匹配级别
     */
    @JsonProperty("level")
    private String level;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getDistrict() {
        return district;
    }

    public void setDistrict(Object district) {
        this.district = district;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
