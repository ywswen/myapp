package com.yyy.dailycode.enjoycoding;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @类名： IDCard
 * @描述： 身份证类
 * @作者： 杨文胜
 * @生成时间： 2014-4-24 下午05:12:44
 * @修改人：
 * @修改时间：
 **/
public class IDCard {
	private static final Logger log = Logger.getLogger(IDCard.class);
	/**
	 * @属性说明：性别：男
	 **/
	private String MALE_SEX = "男";
	/**
	 * @属性说明：性别：女
	 **/
	private String FEMALE_SEX = "女";
	/**
	 * @属性说明：出生日期
	 **/
	private Date birthDay;
	/**
	 * @属性说明：性别
	 **/
	private String SEX;
	/**
	 * @属性说明：籍贯
	 **/
//	private String nativePlace;
	/**
	 * @属性说明：校验码
	 **/
	private static int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	/**
	 * @属性说明：身份证最后一位
	 **/
	private static char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
	/**
	 * @属性说明：身份证号码
	 **/
//	private String idCardNo;

	/**
	 * @生成时间： 2014-4-24 下午05:19:28
	 * @方法说明： 根据传入文件路径和身份证个数，输出${num}个身份证号码到指定文件中
	 * @参数： filePath：文件路径，num：文件个数
	 * @返回值： 是否成功的boolean值
	 * @异常： IOException
	 **/
	public boolean getIDCard(String filePath, int num) throws IOException {
//		File file = new File(filePath);
//		if (!file.exists()) {
//			boolean fileCreateResult = file.createNewFile();
//		}
		return true;
	}

	/**
	 * @生成时间： 2014-4-24 下午05:27:20
	 * @方法说明： 校验身份证号码是否有效
	 * @参数： idCardNo：身份证号码
	 * @返回值： 是否有有效的标识
	 * @异常：
	 **/
	public boolean verifyIDCard(String idCardNo) {
		String msg = null;
		if (idCardNo.length() != 18) {
			msg = "身份证长度不是18位！";
		}
		// String year = idCardNo.substring(6, 10);
		// String month = idCardNo.substring(11, 12);
		// String day = idCardNo.substring(12, 14);
		// String sex = idCardNo.substring(16, 16);
		String birthDay = idCardNo.substring(6, 14);
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyymmdd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sf.parse(birthDay));
			birthDay = sf.format(cal.getTime());
		} catch (ParseException e) {
			msg = "出生日期填写有误！";
		}
		int weighting = 0;
		char[] idCardCharArray = idCardNo.toCharArray();
		for (int i = 0; i < 17; i++) {
			int j =  Integer.parseInt(String.valueOf(idCardCharArray[i]));
			//检验前16位必须是数字
			if (j < 0 || j > 9) {
				msg = "身份证前17位只能是数字";
				break;
			} else {
				//加权求和
				weighting += j * wi[i];
			}
			//设置性别
			if (i == 16 && i % 2 == 0) {
				if (i % 2 == 0) {
					setSEX(MALE_SEX);
				} else {
					setSEX(FEMALE_SEX);
				}
			}
		}
		//加权求和后和校验数组对比
		int mod = weighting % 11;
		if (idCardCharArray[17] != code[mod]) {
			msg = "身份证不正确！";
		}
		if (null != msg) {
			log.info(msg);
			return false;
		} else {
			return true;
		}
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sex) {
		SEX = sex;
	}

	public static void main(String[] args) {
		String idCardNo = "111111111111111111";
		IDCard id = new IDCard();
		id.verifyIDCard(idCardNo);
		log.info(id.SEX);
	}
}
