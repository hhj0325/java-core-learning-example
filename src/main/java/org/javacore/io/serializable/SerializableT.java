package org.javacore.io.serializable;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * 描述:Java序列化和反序列化的小例子
 * Created by 子木 on 2016/2/15.
 */
public class SerializableT {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        for (int i = 0; i < 10; i++) {
            AaObjcet aObjcet = new AaObjcet(i);
            long beginTime = System.currentTimeMillis();
            System.out.println(aObjcet);
            ByteOutputStream byteOutput = new ByteOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
            objectOutput.writeObject(aObjcet);
            objectOutput.close();
            byteOutput.close();
            byte[] bytes = byteOutput.toByteArray();
            // byte[] bytes = byteOutput.getBytes();
            System.out.println("Java序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
            System.out.println("Java序列化后的字节大小为：" + bytes.length);

            beginTime = System.currentTimeMillis();
            ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);
            AaObjcet bObjcet = (AaObjcet)objectInput.readObject();
            System.out.println(bObjcet);
            objectInput.close();
            byteInput.close();
            System.out.println("Java反序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");

        }
    }
}

class AaObjcet implements Serializable {

    private String a = "bysocket";
    private String b = "likes";
    private String c = "java";
    private String d = "world";

    private int i = 100;
    private int j = 10;
    private long m = 100L;

    private boolean isA = true;
    private boolean isB = false;
    private boolean isC = false;

    private BbObject aObject = new BbObject();
    private BbObject bObject = new BbObject();
    private BbObject cObject = new BbObject();
    private BbObject dObject = new BbObject();

    AaObjcet(){

    }

    AaObjcet(int i){
        this();
        this.i = i;
    }


    @Override
    public String toString() {
        return "AaObjcet{" +
            "i='" + i + '\'' +
            "a='" + a + '\'' +
            ", b='" + b + '\'' +
            ", c='" + c + '\'' +
            ", d='" + d + '\'' +
            '}';
    }
}

class BbObject implements Serializable {

}
