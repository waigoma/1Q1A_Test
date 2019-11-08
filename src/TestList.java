import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestList {
    public TestList(List<String> list, List<String> list1, Scanner scan){//順番通りのテスト

        List<String> miss = new ArrayList<>();
        List<String> miss1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            String str = list.get(i);
            String str1 = list1.get(i);

            System.out.println(str);
            String A = scan.next();
            if (A.equalsIgnoreCase(str1)){
                System.out.println("正解！");
            }else {
                miss.add(str);
                miss1.add(str1);
                System.out.println(str1);
            }
        }
        System.out.println(miss);
        System.out.println(miss1);

        if (!(miss.size() == 0)){
            //間違いがあったらretest呼び出し
            retest(miss,miss1);
        }else{
            scan.close();
        }
    }

    private static void retest(List<String> miss, List<String> miss1){
        //間違いのみを再びテスト
        Scanner scan = new Scanner(System.in);

        List<String> miss01 = new ArrayList<>();
        List<String> miss11 = new ArrayList<>();


        for (int i = 0; i < miss.size(); i++) {
            String str = miss.get(i);
            String str1 = miss1.get(i);

            System.out.println(str);
            String A = scan.next();
            if (A.equalsIgnoreCase(str1)) {
                System.out.println("正解！");
            } else {
                System.out.println(str1);
                miss01.add(str);
                miss11.add(str1);
            }
        }
        System.out.println(miss01);
        //System.out.println(miss11);
        if (!(miss01.size() == 0)) {
            //まだ間違いあり
            retest(miss01, miss11);//再びretest呼び出し、再テスト
        } else {
            scan.close();
        }
    }
}
