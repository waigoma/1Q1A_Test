import java.util.List;
import java.util.Scanner;

public class TestStart {//単語のテスト最初の起動場所
    /*
    TODO
    入力でテスト内容を保存できるようにする(ファイルパスとキーワード)
     */
    //左側にある緑の三角ボタンを押せば開始(IntelliJ IDEAの場合)
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("lesson14 : 14\n" + "lesson17 : 17\n" + "lesson25 : 25\n" + "ソクトレ4 : s4\n" + "夢リス4 : y4\n" + "どれやりたい？");//もし追加したらここも追加したほうがいいと思う
        String lesson = scan.next();
        switch (lesson){//どこの単元をやるか決める→TestFileにあらかじめ用意が必要→このswitch構文に追加すれば無限に追加できる
            /*
            追加する場合
            default:
                System.out.println("存在しません");
                scan.close();
                break;
                より上のどこかに
                ↓を追加
            case "好きな文字列or数字":
                System.out.println("好きな文字列(選択したときの通知)")
                new TestLoad(TestFile.好きな名前(ローマ字が好ましい)_imi, TestFile.好きな名前(ローマ字が好ましい)_spell, scan);
                break; ←忘れないように
             */
            case "14":
                System.out.println("lesson14が選択されました");
                new TestLoad(TestFile.lesson14_imi, TestFile.lesson14_spell, scan);
                break;
            case "17":
                System.out.println("lesson17が選択されました");
                new TestLoad(TestFile.lesson17_imi, TestFile.lesson17_spell, scan);
                break;
            case "25":
                System.out.println("lesson25が選択されました");
                new TestLoad(TestFile.lesson25_imi, TestFile.lesson25_spell, scan);
                break;
            case "s4":
                System.out.println("ソクトレ4が選択されました");
                new TestLoad(TestFile.sokutore4_imi, TestFile.sokutore4_spell, scan);
                break;
            case "y4":
                System.out.println("夢リス4が選択されました");
                new TestLoad(TestFile.yumerisu4_imi, TestFile.yumerisu4_spell, scan);
                break;
            case "sk":
                System.out.println("政経が選択されました");
                new TestLoad(TestFile.seikei_imi, TestFile.seikei_spell, scan);
                break;
            default:
                System.out.println("存在しません");
                scan.close();
                break;
        }
    }

    public void start(List<String> list, List<String> list1, Scanner scan){//どの形式でテストをするか決める

        System.out.println("リストテスト = a");
        System.out.println("ランダムテスト = b");
        System.out.println("テスト = c");

        String a = scan.next();
        switch (a){
            case "a":
                System.out.println("リストテストが選択");
                normalTest(list,list1,scan);
                break;
            case "b":
                System.out.println("ランダムテストが選択");
                randomTest(list,list1,scan);
                break;
            case "c":
                System.out.println("テストが選択");
                test(list,list1,scan);
                break;
            default:
                System.out.println("選択範囲外です。システム終了。");
                scan.close();
                break;
        }
    }

    private static void normalTest(List<String> list, List<String> list1, Scanner scan){//順番通りのテスト・間違えた問題を無限に解き直し
        new TestList(list, list1, scan);
    }

    private static void randomTest(List<String> list, List<String> list1, Scanner scan){//順番バラバラでテスト・間違えた問題を無限に解き直し
        new TestRandom(list, list1, scan);
    }

    private static void test(List<String> list, List<String> list1, Scanner scan){//一発勝負のテスト・正答率とかでる
        new Test(list, list1, scan);
    }
}
