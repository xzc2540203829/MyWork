package restful.utils;


public class Byte_Utils {

	public static int getByteIndexOf(byte[] sources, byte[] src, int startIndex, int endIndex) {

		if (sources == null || src == null || sources.length == 0 || src.length == 0) {
			return -1;
		}

		if (endIndex > sources.length) {
			endIndex = sources.length;
		}

		int index, subIndex;

		for (index = startIndex; index < endIndex; index++) {
			if (sources[index] == src[0] && index + src.length < endIndex) {
				for (subIndex = 1; subIndex < src.length; subIndex++) {
					if (sources[index + subIndex] != src[subIndex]) {
						break;
					}
				}

				if (subIndex == src.length) {
					return index;
				}
			}
		}
		return -1;
	}
	public static int ByteArray_TO_Int(byte[] bytes){
		int num=bytes[3] & 0xFF;
		num |=((bytes[2] <<8)& 0xFF00);
		num |=((bytes[1] <<16)& 0xFF0000);
		num |=((bytes[0] <<24)& 0xFF0000);
		return num;
	}
	public static String Byte_To_Bit(byte b) {
		return "" +(byte)((b >> 7) & 0x1) +
			(byte)((b >> 6) & 0x1) +
			(byte)((b >> 5) & 0x1) +
			(byte)((b >> 4) & 0x1) +
			(byte)((b >> 3) & 0x1) +
			(byte)((b >> 2) & 0x1) +
			(byte)((b >> 1) & 0x1) +
			(byte)((b >> 0) & 0x1);
	}
	public static byte Bit_To_Byte(String byteStr) {
		int re, len;
		if (null == byteStr) {
			return 0;
		}
		len = byteStr.length();
		if (len != 4 && len != 8) {
			return 0;
		}
		if (len == 8) {// 8 bit处理
			if (byteStr.charAt(0) == '0') {// 正数
				re = Integer.parseInt(byteStr, 2);
			} else {// 负数
				re = Integer.parseInt(byteStr, 2) - 256;
			}
		} else {//4 bit处理
			re = Integer.parseInt(byteStr, 2);
		}
		return (byte) re;
	}
}
