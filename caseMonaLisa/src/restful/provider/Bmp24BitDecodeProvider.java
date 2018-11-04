package restful.provider;


import org.apache.commons.codec.binary.Base64;
import restful.utils.MonaLisa_Decode_Utils;
import restful.utils.SimpleUploadUtils;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;

@Provider
@Consumes("monaLisa/input")
@Produces("monaLisa/output")
public class Bmp24BitDecodeProvider implements MessageBodyReader<BufferedImage> ,MessageBodyWriter<BufferedImage> {
    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        System.out.println("--------------- isReadable begins ------------------");
        System.out.printf("class:%s\n", aClass.getName());
        System.out.printf("type:%s\n", type.getTypeName());
        System.out.printf("number of annotation:%d\n",annotations.length);
        for(Annotation annotation : annotations) {
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());
        }
        System.out.printf("mediaType:%s\n",mediaType.getType());
        if (type == BufferedImage.class){
            System.out.println("--------------- isReadable ends ------------------");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public BufferedImage readFrom(Class<BufferedImage> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        System.out.println("--------------- readFrom begins ------------------");
        System.out.printf("class:%s\n", aClass.getName());
        System.out.printf("type:%s\n", type.getTypeName());
        System.out.printf("number of annotation:%d\n",annotations.length);
        for(Annotation annotation : annotations) {
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());
        }
        System.out.printf("mediaType:%s\n",mediaType.getType());
        System.out.printf("number of head fields:%d\n",multivaluedMap.keySet().size());
        Iterator<?> keys = multivaluedMap.keySet().iterator();
        while(keys.hasNext()) {
            String key = (String) keys.next();
            System.out.printf("\t %s=%s\n",key,multivaluedMap.get(key).toString() );
        }
        //将输入流转换为bufferedImage对象
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(SimpleUploadUtils.getSingleFileBytesFromEntity(inputStream));
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        System.out.println("--------------- readFrom ends ------------------");
        return bufferedImage;
    }


    @Override
    public boolean isWriteable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        System.out.println("--------------- isWriteable begins ------------------");
        System.out.printf("class:%s\n", aClass.getName());
        System.out.printf("type:%s\n", type.getTypeName());
        System.out.printf("number of annotation:%d\n",annotations.length);
        for(Annotation annotation : annotations) {
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());
        }
        System.out.printf("mediaType:%s\n",mediaType.getType());
        System.out.println("--------------- isWriteable ends ------------------");
        if (type == BufferedImage.class){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public long getSize(BufferedImage bufferedImage, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        System.out.println("--------------- getSize begins ------------------");
        System.out.printf("serializable:%s\n", bufferedImage.getClass());
        System.out.printf("class:%s\n", aClass.getName());
        System.out.printf("type:%s\n", type.getTypeName());
        System.out.printf("number of annotation:%d\n",annotations.length);
        for(Annotation annotation : annotations) {
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());
        }
        System.out.printf("mediaType:%s\n",mediaType.getType());
        System.out.println("--------------- getSize ends ------------------");
        return -1;
    }

    @Override
    public void writeTo(BufferedImage bufferedImage, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        System.out.println("--------------- writeTo begins ------------------");
        System.out.printf("class:%s\n", aClass.getName());
        System.out.printf("type:%s\n", type.getTypeName());
        System.out.printf("number of annotation:%d\n",annotations.length);
        for(Annotation annotation : annotations) {
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());
        }
        System.out.printf("mediaType:%s\n",mediaType.getType());
        System.out.printf("number of head fields:%d\n",multivaluedMap.keySet().size());
        Iterator<?> keys = multivaluedMap.keySet().iterator();
        while(keys.hasNext()) {
            String key = (String) keys.next();
            System.out.printf("\t %s=%s\n",key,multivaluedMap.get(key).toString() );
        }
        int [][][] RGB_Image = MonaLisa_Decode_Utils.BufferedImage_To_PixelArray(bufferedImage);
        byte [] Pixel_Byte_Array = MonaLisa_Decode_Utils.PixelArray_To_Pixel_Byte_Array(RGB_Image);
        byte [] Hide_Mess_All_Byte_Array = MonaLisa_Decode_Utils.Get_Hide_Mess_All_Byte_Array(Pixel_Byte_Array);
        int Hide_Mess_Length =  MonaLisa_Decode_Utils.Get_Hide_Mess_Length(Hide_Mess_All_Byte_Array);
        byte [] Hide_Mess = MonaLisa_Decode_Utils.Get_Hide_Mess(Hide_Mess_Length,Hide_Mess_All_Byte_Array);
        //对输出流进行base64编码
        Base64 base64 = new Base64();
        byte [] Hide_Mess_In_Base64 = base64.encode(Hide_Mess);
        outputStream.write(Hide_Mess_In_Base64);
        System.out.println("--------------- writeTo ends ------------------");
    }
}
