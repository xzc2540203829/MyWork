package restful.api;

public class XORcipherText {
    public static String Algorithm_A(String cipher){

        StringBuffer mess = new StringBuffer();
        for (int i = 0;i < cipher.length();i += 4){
            String Ci = cipher.substring(i,i+2);
            String Ri = cipher.substring(i+2,i+4);
//            System.out.println("ci="+Ci+"  "+"ri="+Ri);
            int ascii16_Key = Integer.valueOf(Ci,16)^Integer.valueOf(Ri,16);
//            System.out.println(ascii16_Key);
            mess.append(asciiToString(String.valueOf(ascii16_Key)));
        }
        return mess.toString();
    }

    public static String Algorithm_B(String mess,String key){

        StringBuffer newkey = new StringBuffer();
//        System.out.println("mess = "+strTo16(mess));
//        System.out.println("key = "+strTo16(key));
        String mess_16 = strTo16(mess);
        String key_16 = strTo16(key);
        int j = 0;
        for (int i = 0;i < mess_16.length();i += 2){
            if(j>key_16.length()-1)
                j = 0;
            String Ti = mess_16.substring(i,i+2);
            String Ki = key_16.substring(j,j+2);
            int ascii16_Key = Integer.valueOf(Ti,16) ^ Integer.valueOf(Ki,16);
//            System.out.println("Ti = "+Ti+"  "+"Ki = "+Ki+"  "+"ascii16_Key = "+ascii16_Key);
            j += 2;
//            System.out.println(asciiToString(String.valueOf(ascii16_Key)));
            newkey.append(asciiToString(String.valueOf(ascii16_Key)));
        }
        return newkey.toString();
    }
    //ascii转String
    public static String asciiToString(String value){

        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0 ; i < chars.length ; i++){
            sbu.append((char)Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    //String转16
    public static String strTo16(String s) {

        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
    //随机数干扰
    public static String disturbByRadomNum(String ciper){

        StringBuffer value = new StringBuffer();
        String hexCiper = strTo16(ciper);
//        System.out.println(hexCiper);
        for (int i = 0;i < hexCiper.length();i += 2){
            int Ti = Integer.valueOf(hexCiper.substring(i,i+2),16);
            int Ri = (int)(Math.random() * 256);
            int Xi = Ti ^ Ri;
//            System.out.println(Xi);
            String strRi;
            String strXi;
            if(Ri < 16){
                strRi = "0" + Integer.toHexString(Ri);
            }else {
                strRi = Integer.toHexString(Ri);
            }
            if(Xi < 16){
                strXi = "0" + Integer.toHexString(Xi);
            }else {
                strXi = Integer.toHexString(Xi);
            }
            value.append(strRi+strXi);
        }
        return value.toString();
    }




    public static void main(String[] args) {

        String key = Algorithm_A("2770d0b53955accfd6b97b160c699ebe7e0aeb843f1fff9cfd9498e8c6ae50358ffd37174f3880efcab8523ef692fcdd");
        System.out.println("key = "+key);
        String newKey = Algorithm_B(key,"0160478");
        System.out.println("newKey = "+strTo16(newKey));
        String reNewKey = disturbByRadomNum(newKey);
        System.out.println("reNewKey = " + reNewKey);
        String cipher2 = Algorithm_B("This is a test !",newKey);
        String reCipher2 = disturbByRadomNum(cipher2);
        System.out.println("reCipher2 = "+reCipher2);
        System.out.println(Algorithm_B(Algorithm_A("5f6c172bf3c0d2f2add6380b98b619291632542d99fdb98b5c71dbe7641c6316"),Algorithm_A("41261145207aeebdb3e84a10c09dd2c27f3a570eb1a10c5bfaa4b3fb025a2773480c80905714144c256f0c50d085382f")));
    }
}
