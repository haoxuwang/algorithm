package wang.haoxu.study;

import org.openjdk.jol.info.ClassLayout;

public class Test {
    static int a[]= new int[2];
    int b ;
    public static void main(String[] args) {
        //Test test = new Test();
        //Test[] test = new Test[10];
        //System.out.println(ClassLayout.parseClass(test.getClass()).toPrintable());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
