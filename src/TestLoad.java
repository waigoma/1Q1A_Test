import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLoad {
    public TestLoad(String pass_imi, String pass_spell, Scanner scan){//テスト問題をロードする(TestStartから呼ばれた時ファイルの場所を受け渡されてロードする)
        try {
            File file = new File(pass_imi);
            File file1 = new File(pass_spell);

            if (!file.exists() || !file1.exists()){
                System.out.println("null");
                return;
            }

            FileReader fileReader = new FileReader(file);
            FileReader fileReader1 = new FileReader(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

            List<String> list = new ArrayList<>();//imi
            List<String> list1 = new ArrayList<>();//spell

            String data;
            String data1;

            while ((data = bufferedReader.readLine()) != null) {
                list.add(data);
            }
            while ((data1 = bufferedReader1.readLine()) != null) {
                list1.add(data1);
            }

            bufferedReader.close();

            TestStart ts = new TestStart();
            ts.start(list, list1, scan);//TestStartのstartメソッド呼び出し

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
