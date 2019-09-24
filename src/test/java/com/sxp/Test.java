package com.sxp;

/**
 * 测试类
 *
 * @author sxp
 * @since 2019/9/24
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Test demo = new Test();
        demo.test();
    }

    public void test() {
        java.net.URL aboutURL = getClass().getResource("/about.html");
        System.out.println(aboutURL);

        aboutURL = Test.class.getResource("/about.html");
        System.out.println(aboutURL);
    }
}
