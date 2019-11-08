import java.util.*;

public class Test {//一発勝負のテスト
    public Test(List<String> list, List<String> list1, Scanner scan) {

        List<Map<String, String>> listmap = new ArrayList<>();

        List<String> miss = new ArrayList<>();//間違えた単語の意味
        List<String> miss1 = new ArrayList<>();//間違えた単語のスペル

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);//imi
            String string1 = list1.get(i);//spell

            map.put(string, string1);
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
        scan.close();
        result(miss,miss1,mlist);
    }

    private void result(List<String> miss, List<String> miss1, List<String> mlist){
        int x = 0;
        int o = 0;
        int m = 0;
        double r = 0;

        m = mlist.size();
        x = miss.size();
        o = m - x;

        r = (double)o / m * 100;

        System.out.println("正解：" + o);
        System.out.println("不正解：" + x);
        System.out.println("正答率：" + r + "%");
        System.out.println("\n不正解解答\n");

        for (int i = 0; i < miss.size(); i++){
            String str = miss.get(i);
            String str1 = miss1.get(i);
            System.out.println(str + "：" + str1);
        }
    }
}
