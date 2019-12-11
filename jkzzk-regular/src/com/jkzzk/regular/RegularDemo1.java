package com.jkzzk.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式： 操作复杂类型文本
 *      1.普通字符
 *          数字、字母、下划线、汉字、以及没有特殊含义的特殊字符、转义字符
 *          这些字符只匹配文本中的与之相同的一个字符
 *      2.标准字符集合
 *          匹配多种字符，区分大小写，大写为反义
 *          /d ： 匹配0-9 10个数字
 *          /w ： 匹配字母、数字、下划线
 *          /s ： 匹配空白字符，空格、制表符、换行符
 *          . ： 匹配除了换行符的任意字符
 *                  如果要匹配所有字符使用[/s/S]
 *      3.自定义字符集合
 *          匹配自定义字符集合，使用方括号[ ... ]包裹
 *          被中括号包裹的字符，失去特殊意义，只匹配本身
 *          被中括号包裹的标准字符集合，不会失去本身意义，将会当做中括号里的一部分
 *          用法：
 *              [abc] ：  匹配 a 或 b 或 c，其中任意一个都可以
 *              [^ abc] ：  匹配 a 或 b 或 c 之外的字符，^ 取反的意思
 *              [a-c] ：匹配 a 到 c 中的任意一个字符
 *      4.量词
 *          {n} ：匹配的字符重复n次
 *          {m,n} ： 匹配的字符至少出现m次，最多出现n次
 *          {m,} ： 匹配的字符至少出现m次
 *          ? ： 匹配的字符至少出现0次，最多出现1次
 *          + ： 匹配的字符至少出现1次
 *          * ： 匹配的字符不出现或出现任意次
 *          量词的模式：
 *              贪婪模式：在匹配范围下，匹配最多的字符
 *              非贪婪模式：在匹配范围下，匹配最少的字符
 *                  默认为贪婪模式，在正则表达式后面加一个问号，？表示启用非贪婪模式
 *          注意：
 *               只修饰前面的一个表达式或是一组表达式
 *      5.字符边界
 *              零宽匹配，匹配的是位置，不是字符
 *          ^ ： 匹配字符串开始的地方
 *          $ ： 匹配字符串结束的地方
 *          \b ： 匹配单词边界
 *              该位置两侧不全是字母、数字、下划线，就是一侧是，另一侧不是，可能是其他字符
 *          注意：
 *              在自定义字符集合中匹配意义会失效
 *      6.匹配模式
 *          1.忽略大小写模式 IGNORECAS
 *              默认是区分大小写的
 *          2.单行模式 SINGLELINE 默认
 *              整个文本只有一个开头，一个结尾，"."可以匹配换行符
 *          3.多行模式 MULTILINE
 *              每一行都有一个开头和结尾，使用^和$来匹配每行的开头结尾
 *              还可以使用\A和\Z来匹配整个文本的开头和结尾
 *       7.选择符 或 | 用来连接两个独立的正则表达式，表示或者关系
 *       8.分组
 *          1.捕获组
 *              使用小括号来表示(),被小括号包起来的表达式，被分为一组
 *              从表达式开始，每一个小括号为一组，编号从 1 开始增加
 *              如果有嵌套，就从外层开始数
 *              从左至右，每一个左小括号，代表一组，开始编号
 *              每一组，会把该表达式匹配到的结果保存下来，可以使用反向引用，来引用该结果字符串
 *          2.非捕获组
 *              格式：(?: )
 *              不存储捕获组捕获的文本，在大量文本匹配时，推荐使用，不需要引用的捕获组，不让他
 *              存储，不然浪费效率
 *          3.反向引用
 *               形势：\nnn   nnn代表该级下的组编号
 *       9.零宽断言
 *          零宽： 表达式匹配的内容不计入在左后的结果之中
 *          概念： 表达式匹配的是该位置之后或之前的字符串，并不记入最后的结果
 *              说明一下要匹配的字符串前后的情况
 *          格式：
 *              (? = exp) ： 匹配字符串后面的情况
 *              (? <= exp) ：匹配字符串前面的情况
 *              (? ! exp) ：匹配字符串后面不能出现的情况
 *              (? < exp) ： 匹配字符串前面不能出现的情况
 *
 *   java中使用正则：
 *      java.util.regex.Pattern 类
 *          三个常用的模式常量
 *              static int CASE_INSENSITIVE 启用不区分大小写的匹配
 *              static int MULTILINE 启用多行模式
 *          编译正则的方法
 *              static Pattern compile(String regex) 将给定的正则表达式编译为模式
 *              static Pattern compile(String regex, int flags) 将给定的正则表达式编译为带有给定标志的模式
 *              Matcher matcher(CharSequence input) 创建一个匹配器，匹配给定的输入与此模式
 *
 *              static boolean matches(String regex, CharSequence input) 编译给定的正则表达式，并尝试匹配给定的输入
 *                  如果只需要查看是否匹配，可以用这个方法，代替上面的一套方法
 *      java.util.regex.Matcher 类
 *              boolean matches() 尝试将整个区域与模式进行匹配
 *                  匹配整个字符串
 *              boolean find() 尝试找到匹配模式的输入序列的下一个子序列
 *                  查找子序列
 *              String group() 返回与上一个匹配匹配的输入子序列。
 *                  返回find方法产找的子序列
 *              String group(int group) 返回在上一次匹配操作期间由给定组捕获的输入子序列
 *                  获取指定捕获组，捕获的内容
 *              String replaceFirst(String replacement)
 *                  将与模式匹配的输入序列的第一个子序列替换为给定的替换字符串
 */
public class RegularDemo1 {

    public static void main(String[] args) throws Exception {

//        show01();

//        show02();

//        show03();

        show04();
    }

    private static void show04() {
        String str = "s123sfsf123123sdfdf45345ktmm66";

        String regxStr = "[0-9]{1,10}";

        Pattern pattern = Pattern.compile(regxStr);

        Matcher matcher = pattern.matcher(str);

        String s = matcher.replaceAll("1111");

        System.out.println(s);
    }

    private static void show03() {
        String str = "s123sfsf123123sdfdf45345ktmm66";

        String regxStr = "([a-z]*)(?:[0-9]*)";

        Pattern pattern = Pattern.compile(regxStr);

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            System.out.println(matcher.group());// s123
            System.out.println(matcher.group(1));// s
            System.out.println(matcher.group(2));// java.lang.IndexOutOfBoundsException: No group 2
        }
    }

    private static void show02() {
        String str = "s123sfsf123123sdfdf45345ktmm66";

        String regxStr = "([a-z]*)([0-9]*)";

        Pattern pattern = Pattern.compile(regxStr);

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            System.out.println(matcher.group());// s123
            System.out.println(matcher.group(1));// s
            System.out.println(matcher.group(2));// 123
        }
    }

    private static void show01() {
        String str = "s123sfsf123123sdfdf45345ktmm66";

        String regxStr = "\\w*";

        Pattern pattern = Pattern.compile(regxStr);

        Matcher matcher = pattern.matcher(str);

        boolean matches = matcher.matches();

        System.out.println(matches);

        /**
         *  该方法的底层，就是使用了匹配器matcher
         *     public static boolean matches(String regex, CharSequence input) {
         *         Pattern p = Pattern.compile(regex);
         *         Matcher m = p.matcher(input);
         *         return m.matches();
         *     }
         * */
        boolean matches1 = Pattern.matches(regxStr, str);

        System.out.println(matches1);
    }
}
