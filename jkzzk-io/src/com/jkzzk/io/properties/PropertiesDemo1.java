package com.jkzzk.io.properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *  java.util.Properties extends java.util.Hashtable<Object,Object> implements Map<K,V>
 *         Properties类表示一组持久的属性,Properties可以保存到流中或从流中加载
 *              可以使用Properties类的store()方法，把集合中的临时数据，持久化写入到硬盘中存储
 *              可以使用Properties类的load()方法，把硬盘中保存的数据（键值对），读取到集合中
 *         属性列表中的每个键及其对应的值都是一个字符串
 *              Properties集合默认是一个双列集合，key和value默认都是字符串
 */
public class PropertiesDemo1 {

    public static void main(String[] args) throws IOException {
//        show01();

//        show02();

        show03();
    }

    /**
     *      可以使用Properties类的load()方法，把硬盘中保存的数据（键值对），读取到集合中
     *          void load(InputStream inStream) 从输入字节流读取属性列表（键和元素对）
     *          void load(Reader reader) 以简单的线性格式从输入字符流读取属性列表（关键字和元素对）
     *          参数：
     *              InputStream inStream：字节输入流，不能读取中文字符
     *              Reader reader：字符输入流，可以读取中文
     *          注意：
     *              1.存储键值的文件中，默认都是以特殊字符连接键值的，一般会用 =
     *              2.存储键值的文件中，可用#进行注释
     *              3.存储键值的文件中，默认就是字符串了，不用加入引号
     * */
    private static void show03() throws IOException {
        Properties properties = new Properties();

        FileReader fileReader = new FileReader("TestFile\\prop.txt");

        properties.load(fileReader);

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            String property = properties.getProperty(string);
            System.out.println(string + "=" + property);
        }

        fileReader.close();
    }

    /**
     *      可以使用Properties类的store()方法，把集合中的临时数据，持久化写入到硬盘中存储
     *          void store(OutputStream out, String comments)
     *          void store(Writer writer, String comments)
     *      参数:
     *          OutputStream out：字节输出流，不能写中文
     *          Writer writer：字符输出流，可以写中文
     *          String comments：文档注释，说明该文件的作用,不能写中文，一般用空字符串""代替
     * */
    private static void show02() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("王","张");
        properties.setProperty("彩","泽");
        properties.setProperty("霞","昆");

        //FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\prop.txt");

        //properties.store(fileOutputStream,"save data");

        //fileOutputStream.close();

        FileWriter fileWriter = new FileWriter("TestFile\\\\prop.txt");

        properties.store(fileWriter,"save data");

        fileWriter.close();
    }

    /**
     *      Properties操作键值的方法
     *          1.Object setProperty(String key, String value) 调用 Hashtable方法 put
     *          2.String getProperty(String key) 使用此属性列表中指定的键搜索属性,通过Key找到值
     *          3.Set<String> stringPropertyNames() 返回此属性列表中的一组键，其中键及其对应的值为字符串
     * */
    private static void show01() {
        Properties properties = new Properties();

        properties.setProperty("王","张");
        properties.setProperty("彩","泽");
        properties.setProperty("霞","昆");

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            String property = properties.getProperty(string);
            System.out.println(string + "=" + property);
        }
    }

}
