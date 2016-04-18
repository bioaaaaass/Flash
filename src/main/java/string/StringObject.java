package string;

import java.lang.reflect.Field;

/**
 * Created by huangzhibo on 4/4/16.
 */
public class StringObject {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab"+"c";

        /** "=="
         * 比较的是对象
         * */
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(c == d);

        /** "equals"
         * 比较的是内容
         * */
        System.out.println("******** equals() *********");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(c.equals(d));

        /***/
        System.out.println("#################################################");
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");

        System.out.println(s0 == s1);
        System.out.println(s1 == s2);

        s1.intern();
        s2 = s2.intern();
        System.out.println(s0 == s1);
        System.out.println(s0 == s1.intern());
        System.out.println(s0 == s2);

        String s = "abcd";
        String ss2 = s;
        System.out.println(s == ss2);
        s = s.concat("ef");
        System.out.println(s == ss2);


        /**
         * 测试反射
         * */
        String str = "Hello World";
        System.out.println("str=" + str);
        try {
            Field valueFieldOfString = String.class.getDeclaredField("value");
            valueFieldOfString.setAccessible(true);
            char[] value = (char[]) valueFieldOfString.get(str);
            value[5] = '_';
            System.out.println("str=" +str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("str=" +str);
    }
}
