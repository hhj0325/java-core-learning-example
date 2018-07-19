package org.javacore.collection.set;

import java.util.TreeSet;
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

/**
 * @author Jeff Lee
 * @since 2015-6-19 15:46:37
 * 	TreeSet操作已实现Comparable接口的对象
 */
public class TreeSetT{
	public static void main(String[] args){
		TreeSet<Bird> bSet = new TreeSet<Bird>();
		bSet.add(new Bird(1));
		bSet.add(new Bird(3));
		bSet.add(new Bird(2));

        System.out.println(bSet);
	}
}
/**
 * Bird对象 实现了Comparable接口
 */
class Bird implements Comparable<Bird>{
	int num;
	public Bird(int num){
        this.num = num;
	}

	@Override
    public String toString(){
		return num + "号鸟";
	}

	@Override
	public int compareTo(Bird o){
		return num - o.num;
	}
}
