package test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {

    class Usr implements Comparable {
        private String ln;
        private String fn;
        private String sn;
        private Integer age;
        private String pass;

        public Usr(String ln, String fn, String sn, Integer age, String pass) {
            this.ln = ln;
            this.fn = fn;
            this.sn = sn;
            this.age = age;
            this.pass = pass;
        }

        public int compareTo(Object o) {
            return age.compareTo(((Usr)o).age);
//            return ln.compareTo(((Usr)o).getLn());
        }

        public String toString() {
            return ln + "," + fn + "," + sn + "," + age + "," + pass;
        }
    }

    public void method() throws Exception {
        String[] o = Files.lines(Paths.get("files/test2.txt"), Charset.forName("Cp1251")).toArray(String[]::new);
        List<Usr> list = new ArrayList<Usr>();
        for (int i=0; i<o.length; i=i+5) {
            Usr usr = new Usr(o[i], o[i+1], o[i+2], o[i+3].isEmpty() ? 0 : Integer.parseInt(o[i+3]), o[i+4]);
            list.add(usr);
        }
        Collections.sort(list);
        for (Usr u : list)
            System.out.println(u);
    }

    public static void main(String[] args) {
        Test3 test = new Test3();
        try { test.method(); } catch (Exception ex) { ex.printStackTrace(); }
    }
}
