package org.javacore.io.byteoper;
/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;

/**
 * @author Jeff Lee
 * @since 2015-6-19 21:26:04
 * 	Long与byte数组转换
 */
public class LongConvertT {

    public static void main(String[] args){
        // 将我的学号转换成字节码
        byte[] bytes = LongConvertT.long2Bytes(2009213827L);
        System.out.println(Arrays.toString(bytes));
        // 字节码就可以转换回学号
        System.out.println(LongConvertT.bytes2Long(bytes));
    }

	/**
	 * long 转 byte数组
	 */
	public static byte[] long2Bytes(long longa){
		byte[] bytes = new byte[8];
		for (int i = 0; i < bytes.length; i++) {
		    // 移位和清零
            bytes[i] = (byte) (long) (((longa) >> i * 8) & 0xff);
        }

		return bytes;
	}

	/**
	 * byte数组 转 long
	 */
	public static long bytes2Long(byte[] bytes){
		long longa = 0;
		for (int i = 0; i < bytes.length; i++) {
            // 移位和清零
            longa += (long) ((bytes[i] & 0xff) << i * 8);
        }

		return longa;
	}
}
