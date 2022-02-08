package com.znczLfylGkj.yz;

public class ZhiLingUtil {
	
	/**
	 * 
	 * @return  µÄ³µÁ¾Èë³§
	 */
	public static String get81() {
		return getByDuanHao(81);
	}
	
	/**
	 * 
	 * @return  Çë³µÅÆºÅÎª
	 */
	public static String get83() {
		return getByDuanHao(83);
	}

	public static String getByDuanHao(int num) {
		String zlStr=null;
		switch (num) {
		case 1:
			zlStr="F0 01 06 04 01 FC";
			break;
		case 2:
			zlStr="F0 01 06 04 02 FD";
			break;
		case 3:
			zlStr="F0 01 06 04 03 FE";
			break;
		case 4:
			zlStr="F0 01 06 04 04 FF";
			break;
		case 5:
			zlStr="F0 01 06 04 05 00";
			break;
		case 6:
			zlStr="F0 01 06 04 06 01";
			break;
		case 7:
			zlStr="F0 01 06 04 07 02";
			break;
		case 8:
			zlStr="F0 01 06 04 08 03";
			break;
		case 9:
			zlStr="F0 01 06 04 09 04";
			break;
		case 10:
			zlStr="F0 01 06 04 0A 05";
			break;
		case 11:
			zlStr="";
			break;
		case 54:
			zlStr="F0 01 06 04 36 31";
			break;
		case 81:
			zlStr="F0 01 06 04 51 4C";
			break;
		case 83:
			zlStr="F0 01 06 04 53 4E";
			break;
		}
		return zlStr;
	}
	
	public static String getByStr(String str) {
		String zlStr=null;
		switch (str) {
		case "0": 
			zlStr=getByDuanHao(36);
			break;
		case "1": 
			zlStr=getByDuanHao(1);
			break;
		case "2": 
			zlStr=getByDuanHao(2);
			break;
		case "3":
			zlStr=getByDuanHao(3);
			break;
		case "4":
			zlStr=getByDuanHao(4);
			break;
		case "5":
			zlStr=getByDuanHao(5);
			break;
		case "6":
			zlStr=getByDuanHao(6);
			break;
		case "7":
			zlStr=getByDuanHao(7);
			break;
		case "8":
			zlStr=getByDuanHao(8);
			break;
		case "9":
			zlStr=getByDuanHao(9);
			break;
		case "A":
			zlStr=getByDuanHao(10);
			break;
		case "B":
			zlStr=getByDuanHao(11);
			break;
		case "C":
			zlStr=getByDuanHao(12);
			break;
		case "D":
			zlStr=getByDuanHao(13);
			break;
		case "E":
			zlStr=getByDuanHao(14);
			break;
		case "F":
			zlStr=getByDuanHao(15);
			break;
		case "G":
			zlStr=getByDuanHao(16);
			break;
		case "H":
			zlStr=getByDuanHao(17);
			break;
		case "I":
			zlStr=getByDuanHao(18);
			break;
		case "J":
			zlStr=getByDuanHao(19);
			break;
		case "K":
			zlStr=getByDuanHao(20);
			break;
		case "L":
			zlStr=getByDuanHao(21);
			break;
		case "M":
			zlStr=getByDuanHao(22);
			break;
		case "N":
			zlStr=getByDuanHao(23);
			break;
		case "O":
			zlStr=getByDuanHao(24);
			break;
		case "P":
			zlStr=getByDuanHao(25);
			break;
		case "Q":
			zlStr=getByDuanHao(26);
			break;
		case "R":
			zlStr=getByDuanHao(27);
			break;
		case "S":
			zlStr=getByDuanHao(28);
			break;
		case "T":
			zlStr=getByDuanHao(29);
			break;
		case "U":
			zlStr=getByDuanHao(30);
			break;
		case "V":
			zlStr=getByDuanHao(31);
			break;
		case "W":
			zlStr=getByDuanHao(32);
			break;
		case "X":
			zlStr=getByDuanHao(33);
			break;
		case "Y":
			zlStr=getByDuanHao(34);
			break;
		case "Z":
			zlStr=getByDuanHao(35);
			break;
		case "²Ø":	
			zlStr=getByDuanHao(41); 
			break;
		case "¸Ê":	
			zlStr=getByDuanHao(42); 
			break;
		case "¸Ó":	
			zlStr=getByDuanHao(43); 
			break;
		case "¹ó":	
			zlStr=getByDuanHao(44); 
			break;
		case "¹ð":	
			zlStr=getByDuanHao(45); 
			break;
		case "ºÚ":	
			zlStr=getByDuanHao(46); 
			break;
		case "»¦":	
			zlStr=getByDuanHao(47); 
			break;
		case "¼ª":	
			zlStr=getByDuanHao(48); 
			break;
		case "¼½":	
			zlStr=getByDuanHao(49); 
			break;
		case "½ò":	
			zlStr=getByDuanHao(50); 
			break;
		case "½ú":	
			zlStr=getByDuanHao(51); 
			break;
		case "¾©":	
			zlStr=getByDuanHao(52); 
			break;
		case "ÁÉ":	
			zlStr=getByDuanHao(53); 
			break;
		case "Â³":	
			zlStr=getByDuanHao(54); 
			break;
		case "ÃÉ":	
			zlStr=getByDuanHao(55); 
			break;
		case "Ãö":	
			zlStr=getByDuanHao(56); 
			break;
		case "Çà":	
			zlStr=getByDuanHao(57); 
			break;
		case "Çí":	
			zlStr=getByDuanHao(58); 
			break;
		case "ÉÂ":	
			zlStr=getByDuanHao(59); 
			break;
		case "ËÕ":	
			zlStr=getByDuanHao(60); 
			break;
		case "Íî":	
			zlStr=getByDuanHao(61); 
			break;
		case "Ïæ":	
			zlStr=getByDuanHao(62); 
			break;
		case "ÐÂ":	
			zlStr=getByDuanHao(63); 
			break;
		case "Óå":	
			zlStr=getByDuanHao(64); 
			break;
		case "Ô¥":	
			zlStr=getByDuanHao(65); 
			break;
		case "ÔÁ":	
			zlStr=getByDuanHao(66); 
			break;
		case "ÔÆ":	
			zlStr=getByDuanHao(67); 
			break;
		case "Õã":	
			zlStr=getByDuanHao(68);
			break;
		}
		return zlStr;
	}
}
