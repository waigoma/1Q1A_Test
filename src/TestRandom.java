import java.util.*;

public class TestRandom {
    public TestRandom(List<String> list, List<String> list1, Scanner scan){//順番バラバラでテスト

        List<Map<String,String>> listmap = new ArrayList<>();

        List<String> miss = new ArrayList<>();//間違えた単語の意味
        List<String> miss1 = new ArrayList<>();//間違えた単語のスペル

        Map<String,String> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++){
            String string = list.get(i);//imi
            String string1 = list1.get(i);//spell

            map.put(string,string1);
        }
        listmap.add(map);

        //Collections.shuffle(listmap);//listに入ったmapをランダムに
        /*
        ここで毎回同じランダム配置になっちゃう
        [あ,い,う,え,お] → [あ,え,い,う,お]←毎回これになる
         */

        List<String> mlist = new ArrayList<>();//imi
        //List<String> mlist1 = new ArrayList<>();//spell

        for (Map<String, String> m : listmap) {
            mlist.addAll(m.keySet());
            //mlist1.addAll(m.values());
        }

        Collections.shuffle(mlist);


        for (String str : mlist) {
            String str1 = map.get(str);

            System.out.println(str);//意味表示
            String A = scan.next();//撃ち込まれた単語を読み取る
            if (A.equalsIgnoreCase(str1)) {
                System.out.println("正解！");//意味と単語が一致したら
            } else {
                miss.add(str);//意味と単語が間違ってたら
                miss1.add(str1);//missのリストに追加
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
