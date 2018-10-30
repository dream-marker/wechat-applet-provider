package cn.blmdz.wapplet.model.sdk.weather.enums;

import com.google.common.base.Objects;

public enum EnumsHeweatherCodeIcon {

	CODE_100(100, "100.png", "100n.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "晴", "Sunny/Clear"),
	CODE_101(101, "101.png", "101.png", "day_cloud.jpg", "night_cloud.jpg", "#62aadc", "#27446f", "多云", "Cloudy"),
	CODE_102(102, "102.png", "102.png", "day_cloud.jpg", "night_cloud.jpg", "#62aadc", "#27446f", "少云", "Few Clouds"),
	CODE_103(103, "103.png", "103n.png", "day_cloud.jpg", "night_cloud.jpg", "#62aadc", "#27446f", "晴间多云", "Partly Cloudy"),
	CODE_104(104, "104.png", "104n.png", "day_overcast.jpg", "night_overcast.jpg", "#5c7a93", "#22364d", "阴", "Overcast"),
	CODE_200(200, "200.png", "200.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "有风", "Windy"),
	CODE_201(201, "201.png", "201.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "平静", "Calm"),
	CODE_202(202, "202.png", "202.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "微风", "Light Breeze"),
	CODE_203(203, "203.png", "203.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "和风", "Moderate/Gentle Breeze"),
	CODE_204(204, "204.png", "204.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "清风", "Fresh Breeze"),
	CODE_205(205, "205.png", "205.png", "day_overcast.jpg", "night_overcast.jpg", "#5c7a93", "#22364d", "强风/劲风", "Strong Breeze"),
	CODE_206(206, "206.png", "206.png", "day_overcast.jpg", "night_overcast.jpg", "#5c7a93", "#22364d", "疾风", "High Wind, Near Gale"),
	CODE_207(207, "207.png", "207.png", "day_overcast.jpg", "night_overcast.jpg", "#5c7a93", "#22364d", "大风", "Gale"),
	CODE_208(208, "208.png", "208.png", "day_overcast.jpg", "night_overcast.jpg", "#5c7a93", "#22364d", "烈风", "Strong Gale"),
	CODE_209(209, "209.png", "209.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "风暴", "Storm"),
	CODE_210(210, "210.png", "210.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "狂爆风", "Violent Storm"),
	CODE_211(211, "211.png", "211.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "飓风", "Hurricane"),
	CODE_212(212, "212.png", "212.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "龙卷风", "Tornado"),
	CODE_213(213, "213.png", "213.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "热带风暴", "Tropical Storm"),
	CODE_300(300, "300.png", "300n.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "阵雨", "Shower Rain"),
	CODE_301(301, "301.png", "301n.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "强阵雨", "Heavy Shower Rain"),
	CODE_302(302, "302.png", "302.png", "day_thunder.jpg", "night_thunder.jpg", "#3a4482", "#2a2b5a", "雷阵雨", "Thundershower"),
	CODE_303(303, "303.png", "303.png", "day_thunder.jpg", "night_thunder.jpg", "#3a4482", "#2a2b5a", "强雷阵雨", "Heavy Thunderstorm"),
	CODE_304(304, "304.png", "304.png", "day_thunder.jpg", "night_thunder.jpg", "#3a4482", "#2a2b5a", "雷阵雨伴有冰雹", "Thundershower with hail"),
	CODE_305(305, "305.png", "305.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "小雨", "Light Rain"),
	CODE_306(306, "306.png", "306.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "中雨", "Moderate Rain"),
	CODE_307(307, "307.png", "307.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "大雨", "Heavy Rain"),
	CODE_308(308, "308.png", "308.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "极端降雨", "Extreme Rain"),
	CODE_309(309, "309.png", "309.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "毛毛雨/细雨", "Drizzle Rain"),
	CODE_310(310, "310.png", "310.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "暴雨", "Storm"),
	CODE_311(311, "311.png", "311.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "大暴雨", "Heavy Storm"),
	CODE_312(312, "312.png", "312.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "特大暴雨", "Severe Storm"),
	CODE_313(313, "313.png", "313.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "冻雨", "Freezing Rain"),
	CODE_314(314, "314.png", "314.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "小到中雨", "Light to moderate rain"),
	CODE_315(315, "315.png", "315.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "中到大雨", "Moderate to heavy rain"),
	CODE_316(316, "316.png", "316.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "大到暴雨", "Heavy rain to storm"),
	CODE_317(317, "317.png", "317.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "暴雨到大暴雨", "Storm to heavy storm"),
	CODE_318(318, "318.png", "318.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "大暴雨到特大暴雨", "Heavy to severe storm"),
	CODE_399(399, "399.png", "399.png", "day_rain.jpg", "night_rain.jpg", "#2f4484", "#284469", "雨", "Rain"),
	CODE_400(400, "400.png", "400.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "小雪", "Light Snow"),
	CODE_401(401, "401.png", "401.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "中雪", "Moderate Snow"),
	CODE_402(402, "402.png", "402.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "大雪", "Heavy Snow"),
	CODE_403(403, "403.png", "403.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "暴雪", "Snowstorm"),
	CODE_404(404, "404.png", "404.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "雨夹雪", "Sleet"),
	CODE_405(405, "405.png", "405.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "雨雪天气", "Rain And Snow"),
	CODE_406(406, "406.png", "406n.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "阵雨夹雪", "Shower Snow"),
	CODE_407(407, "407.png", "407n.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "阵雪", "Snow Flurry"),
	CODE_408(408, "408.png", "408.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "小到中雪", "Light to moderate snow"),
	CODE_409(409, "409.png", "409.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "中到大雪", "Moderate to heavy snow"),
	CODE_410(410, "410.png", "410.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "大到暴雪", "Heavy snow to snowstorm"),
	CODE_499(499, "499.png", "499.png", "day_snow.jpg", "night_snow.jpg", "#95d1ed", "#7a98bc", "雪", "Snow"),
	CODE_500(500, "500.png", "500.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "薄雾", "Mist"),
	CODE_501(501, "501.png", "501.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "雾", "Foggy"),
	CODE_502(502, "502.png", "502.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "霾", "Haze"),
	CODE_503(503, "503.png", "503.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "扬沙", "Sand"),
	CODE_504(504, "504.png", "504.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "浮尘", "Dust"),
	CODE_507(507, "507.png", "507.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "沙尘暴", "Duststorm"),
	CODE_508(508, "508.png", "508.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "强沙尘暴", "Sandstorm"),
	CODE_509(509, "509.png", "509.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "浓雾", "Dense fog"),
	CODE_510(510, "510.png", "510.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "强浓雾", "Strong fog"),
	CODE_511(511, "511.png", "511.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "中度霾", "Moderate haze"),
	CODE_512(512, "512.png", "512.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "重度霾", "Heavy haze"),
	CODE_513(513, "513.png", "513.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "严重霾", "Severe haze"),
	CODE_514(514, "514.png", "514.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "大雾", "Heavy fog"),
	CODE_515(515, "515.png", "515.png", "day_smog.jpg", "night_smog.jpg", "#494d57", "#494d57", "特强浓雾", "Extra heavy fog"),
	CODE_900(900, "900.png", "900.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "热", "Hot"),
	CODE_901(901, "901.png", "901.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "冷", "Cold"),
	CODE_999(999, "999.png", "999.png", "day_clear.jpg", "night_clear.jpg", "#57b9e2", "#173868", "未知", "Unknown"),
	
	;

	private final Integer code;
	private final String dayIcon;
	private final String nightIcon;
	private final String dayBg;
	private final String nightBg;
	private final String dayBgColor;
	private final String nightBgColor;
	private final String description;
	
    public final Integer code() {
        return code;
    }
    public final String dayIcon() {
    	return dayIcon;
    }
    public final String nightIcon() {
    	return nightIcon;
    }
    public final String dayBg() {
    	return dayBg;
    }
    public final String nightBg() {
    	return nightBg;
    }
    public final String dayBgColor() {
    	return dayBgColor;
    }
    public final String nightBgColor() {
    	return nightBgColor;
    }
    public final String description() {
    	return description;
    }
	
	EnumsHeweatherCodeIcon(Integer code, String dayIcon, String nightIcon, String dayBg, String nightBg, String dayBgColor, String nightBgColor, String description, String english) {
		this.code = code;
		this.dayIcon = dayIcon;
		this.nightIcon = nightIcon;
		this.dayBg = dayBg;
		this.nightBg = nightBg;
		this.dayBgColor = dayBgColor;
		this.nightBgColor = nightBgColor;
		this.description = description;
	}

    public static EnumsHeweatherCodeIcon conversion(int code) {
        for (EnumsHeweatherCodeIcon item : EnumsHeweatherCodeIcon.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
