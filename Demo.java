package ankur.graph;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Demo {
    static BigDecimal b1 = new BigDecimal("12.2");
    static BigDecimal b2 = new BigDecimal("10.12");
    public static void main(String[] args) {

        /*System.out.println(b1.multiply(b2));

        char c = '@';
        if(Character.isDigit(c)){
            System.out.println(Integer.parseInt(String.valueOf(c))*3);
        }
        else if(Character.isLetter(c)){
            System.out.println(Character.toUpperCase(c));
        }
        else{
            System.out.println("Invalid");
        }
        // true, false, null are reserved words
        System.out.println(0.0/0.0); // NaN
//        System.out.println(0/0); // error(division by 0)
        System.out.println(5/0.0); // infinity



        String s = "4";
//        Integer.parseInt(s); // this return the corresponding primitive data type
//        Integer a = Integer.valueOf(s); // this returns the object of the corresponding object

        float f = Float.parseFloat(s);

        Float f1 = Float.valueOf(s);

        System.out.println(f + " " + f1);
        System.out.println(1 >>> 3);

        int x = 10;
        int y = 20;
        if(x > y | ++y > 2) {
            System.out.println(y);
        }
        else {
            System.out.println("No" + y);
        }

        System.out.println((byte)64 << (byte)2); // double -> float -> long -> long this is the hierarchy for expression evaluation

        System.out.println(-1>>24); // maintains the negativity and positevity of a number*/


        Employee e1 = new Employee(1,"Ankur");

        System.out.println(e1.toString());


    }

    public static List<Integer> longStr(String s, String[] c, int q){
        int k = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int count=0;
            int len=1;
            int maxLen = 1;
            for(int j=i;j<s.length()-1;j++){
                if(s.charAt(j) == s.charAt(j+1)){
                    len++;
                }
                if(s.charAt(j) != s.charAt(j+1)){
                    maxLen = Math.max(len, maxLen);
                    len = 1;
                }
            }
            res.add(maxLen);
            if(k == q){
                return res;
            }
            s += c[k];
            k++;
        }
        return res;
    }
}
class Employee{
    private int id;
    String name;
    Employee(){

    }
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
