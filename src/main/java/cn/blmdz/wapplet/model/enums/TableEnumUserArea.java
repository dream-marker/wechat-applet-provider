package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

/**
 * @author xpoll
 */
public enum TableEnumUserArea {

	AREA_0(-1, "??", "??"),
	AREA_1(1, "京", "北京"),
	AREA_2(2, "津", "天津"),
	AREA_3(3, "冀", "河北"),
	AREA_4(4, "晋", "山西"),
	AREA_5(5, "蒙", "内蒙古"),
	AREA_6(6, "辽", "辽宁"),
	AREA_7(7, "吉", "吉林"),
	AREA_8(8, "黑", "黑龙江"),
	AREA_9(9, "沪", "上海"),
	AREA_10(10, "苏", "江苏"),
	AREA_11(11, "浙", "浙江"),
	AREA_12(12, "皖", "安徽"),
	AREA_13(13, "闽", "福建"),
	AREA_14(14, "赣", "江西"),
	AREA_15(15, "鲁", "山东"),
	AREA_16(16, "豫", "河南"),
	AREA_17(17, "鄂", "湖北"),
	AREA_18(18, "湘", "湖南"),
	AREA_19(19, "粤", "广东"),
	AREA_20(20, "桂", "广西"),
	AREA_21(21, "琼", "海南"),
	AREA_22(22, "川", "四川"),
	AREA_23(23, "黔", "贵州"),
	AREA_24(24, "滇", "云南"),
	AREA_25(25, "渝", "重庆"),
	AREA_26(26, "藏", "西藏"),
	AREA_27(27, "陕", "陕西"),
	AREA_28(28, "甘", "甘肃"),
	AREA_29(29, "青", "青海"),
	AREA_30(30, "宁", "宁夏"),
	AREA_31(31, "新", "新疆"),
	AREA_32(32, "港", "香港"),
	AREA_33(33, "澳", "澳门"),
	AREA_34(34, "台", "台湾"),
    
    ;

    private final int code;
    private final String show;
    private final String description;

    public int code() {
        return this.code;
    }
    public String show() {
        return show;
    }
    public String description() {
        return description;
    }

    private TableEnumUserArea(int code, String show, String description) {
        this.code = code;
        this.show = show;
        this.description = description;
    }

    public static TableEnumUserArea conversion(int code) {
        for (TableEnumUserArea item : TableEnumUserArea.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
