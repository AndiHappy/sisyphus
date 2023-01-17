package jdkExample;

/**
 * test 运行时的常量池
 * 这段代码在JDK 6中运行，会得到两个false，而在JDK 7中运行，会得到一个true和一个false。
 *
 * 产生差异的原因是：
 *      在JDK 6中，intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池中存储，返回的也是永久代里面这个字符串实例的引用，
 *      而由StringBuilder创建的字符串对象实例在Java堆上，所以必然不可能是同一个引用，结果将返回false。
 *
 *      在JDK 7(以及部分其他虚拟机，例如JRockit)的intern()方法实现就不需要再拷贝字符串的实例到永久代了，
 *      既然字符串常量池已经移到Java堆中，那只需要在常量池里记录一下首次出现的实例引用即可 ,因此intern()返回的引用由
 *      由StringBuilder创建的那个字符串实例是同一个，所以使用JDK7的str1的比较返回true。 而对str2而言，返回false，是因为java这个字符串
 *      在执行Stringbuilder之前的代码就已经在常量池中出现过了，具体出现的时机是，加载：sun.misc.Version这个类的时候进入常量池的。
 *      所以和现在代码新建的这个就不一样了，返回false。
 * */
public class RuntimeConstantPoolOOM_2 {

    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja-zhai").append("va-test").toString();
        System.out.println(str3.intern() == str3);
    }
}