package restful.utils;

import java.awt.image.BufferedImage;

public class MonaLisa_Decode_Utils {
    public static int [][][] BufferedImage_To_PixelArray(BufferedImage bufferedImage) {
        int green = 0, red = 0, blue = 0;
        int imageWidth = bufferedImage.getWidth();
        int imageHeight = bufferedImage.getHeight();
        int[][][] RGB_Image = new int[imageWidth][imageHeight][3];
        for (int i = bufferedImage.getMinX(); i < imageWidth; i++) {
            for (int j = bufferedImage.getMinY(); j < imageHeight; j++) {
                Object data = bufferedImage.getRaster().getDataElements(i, j, null);//获取该点像素，并以object类型表示
                red = bufferedImage.getColorModel().getRed(data);
                blue = bufferedImage.getColorModel().getBlue(data);
                green = bufferedImage.getColorModel().getGreen(data);
                RGB_Image[i][j][0] = red;
                RGB_Image[i][j][1] = green;
                RGB_Image[i][j][2] = blue;
            }
        }
        return RGB_Image;
    }
    public static byte [] PixelArray_To_Pixel_Byte_Array(int [][][] RGB_Image) {
        byte [] Pixel_Byte_Array = new byte[RGB_Image.length*RGB_Image[0].length*3];
        int index = 0;
        for (int i = 0 ; i < RGB_Image[0].length ; i ++){
            for (int j = 0 ; j < RGB_Image.length ; j ++){
                for (int k = 0 ; k < 3 ; k ++){
                    Pixel_Byte_Array[index] = (byte)RGB_Image[j][i][k];
                    index ++;
                }
            }
        }
        return Pixel_Byte_Array;
    }
    public static byte [] Get_Hide_Mess_All_Byte_Array(byte [] Pixel_Byte_Array) {
        byte [] Hide_Mess_All_Byte_Array = new byte[Pixel_Byte_Array.length*3/8];
        StringBuffer Hide_Mess_StringBuffer = new StringBuffer();
        for (int i = 0 ; i < Pixel_Byte_Array.length ; i ++){
            Hide_Mess_StringBuffer.append(Byte_Utils.Byte_To_Bit(Pixel_Byte_Array[i]).charAt(7));
            if (Hide_Mess_StringBuffer.length() == 8){
                Hide_Mess_All_Byte_Array[i/8] = Byte_Utils.Bit_To_Byte(Hide_Mess_StringBuffer.reverse().toString());
                Hide_Mess_StringBuffer.delete(0,8);
            }
        }
        return Hide_Mess_All_Byte_Array;
    }
    public static int Get_Hide_Mess_Length(byte [] Hide_Mess_All_Byte_Array) {
        int Hide_Mess_Length = 0;
        byte [] Hide_Mess_Length_Byte = new byte[4];
        for (int i = 0 ; i < 4 ; i ++ ){
            Hide_Mess_Length_Byte[3-i] = Hide_Mess_All_Byte_Array[i];
        }
        Hide_Mess_Length = Byte_Utils.ByteArray_TO_Int(Hide_Mess_Length_Byte);
        return Hide_Mess_Length;
    }
    public static byte [] Get_Hide_Mess(int Hide_Mess_Length,byte [] Hide_Mess_All_Byte_Array) {
        byte [] Hide_Mess = new byte[Hide_Mess_Length];
        for (int i = 4 ; i < Hide_Mess.length ; i ++){
            Hide_Mess[i - 4] = Hide_Mess_All_Byte_Array[i];
        }
        return Hide_Mess;
    }



}
