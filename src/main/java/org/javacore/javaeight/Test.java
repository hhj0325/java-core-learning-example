package org.javacore.javaeight;

import java.io.File;

/**
 * Created by huhaojian on 2018/12/7 0007.
 */
public class Test {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        System.out.println(hiddenFiles.length);

    }


}
