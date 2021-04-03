package test;

import java.util.Arrays;

public class Test1 {
    public boolean method(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i<c1.length; i++)
            if (c1[i] != c2[i])
                return false;
        return true;
    }

    public static void main(String args[]) {
        Test1 test = new Test1();
        System.out.println(test.method("dog", "dgo"));
        System.out.println(test.method("dog", "dfo"));
        System.out.println(test.method("doog", "ddgo"));
    }
}
