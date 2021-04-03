package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test2 {

    // сделать возраст опциональным, строка с возрастом может быть пустой
    // отсортировать список перед его выводом, null - впереди
    public void method() throws IOException {
        String file = "files/test2.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "cp1251"));
        String s;
        int ind = 0;
        Usr usr = new Usr();
        ArrayList<Usr> res = new ArrayList<>();
        while ((s = br.readLine())!= null) {
            ind++;
            usr.setF(s, ind);
            if (ind % 5 == 0) {
                res.add(usr);
                usr = new Usr();
                ind = 0;
            }
        }
        br.close();
        Collections.sort(res);
        for (int i=0; i<res.size(); i++)
            System.out.println(res.get(i));
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        try {
            test.method();
        } catch (IOException ex) {

        }
    }

    class Usr implements Comparable {
        private String ln;
        private String fn;
        private String sn;
        private Integer age;
        private String pass;
        public void setF(String s, int ind) {
            switch (ind) {
                case 1:
                    ln = s;
                    break;
                case 2:
                    fn = s;
                    break;
                case 3:
                    sn = s;
                    break;
                case 4:
                    age = s != null && !s.isEmpty() ? Integer.parseInt(s) : 0;
                    break;
                case 5:
                    pass = s;
                    break;
                default:
            }
        }

        public String getLn() { return ln; }
        public String getFn() { return fn; }
        public String getSn() { return sn; }
        public int getAge() { return age; }
        public String getPass() { return pass; }
        public int compareTo(Object o) {
            return age.compareTo(((Usr)o).getAge());
//            return ln.compareTo(((Usr)o).getLn());
        }

        public String toString() {
            return ln + "," + fn + "," + sn + "," + age + "," + pass;
        }
    }
}
