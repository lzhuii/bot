package bot.model.amap;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hui
 * @since 2024-01-09 10:22:07
 */
public class WeatherLive {
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 地区代码
     */
    @JsonProperty("adcode")
    private String adCode;
    /**
     * 天气现象（汉字描述）
     */
    private String weather;
    /**
     * 实时气温，单位：摄氏度
     */
    private String temperature;
    /**
     * 风向描述
     */
    @JsonProperty("winddirection")
    private String windDirection;
    /**
     * 风力级别，单位：级
     */
    @JsonProperty("windpower")
    private String windPower;
    /**
     * 空气湿度
     */
    private String humidity;
    /**
     * 数据发布的时间
     */
    @JsonProperty("reporttime")
    private String reportTime;

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

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
