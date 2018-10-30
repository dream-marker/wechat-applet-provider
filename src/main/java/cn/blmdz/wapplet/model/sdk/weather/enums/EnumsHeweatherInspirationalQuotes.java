package cn.blmdz.wapplet.model.sdk.weather.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum EnumsHeweatherInspirationalQuotes {

	IQ_1("生活是天气，有阴有晴有风雨"),
	IQ_2("心怀感恩，幸福常在"),
	IQ_3("心累的时候，换个心情看世界"),
	IQ_4("想获得人生的金子，就必须淘尽生活的沙烁"),
	IQ_5("因为有明天，今天永远只是起跑线"),
	IQ_6("只要心情是晴朗的，人生就没有雨天"),
	IQ_7("有你的城市下雨也美丽"),
	IQ_8("雨划过我窗前，玻璃也在流眼泪"),
	IQ_9("天空澄碧，纤云不染"),
	IQ_10("人生，不要被安逸所控制"),
	IQ_11("在受伤的时候，也能浅浅的微笑"),
	IQ_12("不抱怨过去，不迷茫未来，只感恩现在"),
	IQ_13("生活向前，你向阳光"),
	IQ_14("在阳光中我学会欢笑，在阴云中我学会坚强"),
    ;
    
	private final String description;
	
    public final String description() {
    	return description;
    }
	
	EnumsHeweatherInspirationalQuotes(String description) {
		this.description = description;
	}
	
	public static String selectOne() {
		EnumsHeweatherInspirationalQuotes[] items = EnumsHeweatherInspirationalQuotes.values();
		return items[ThreadLocalRandom.current().nextInt(items.length)].description;
	}
}
