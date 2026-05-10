package src.com.CzlR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCode());
    }


    public static String getCode(){
        List<Character> chartable = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            chartable.add((char)('a' + i));
            chartable.add((char)('A' + i));
        }
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for(int i = 0; i < 4; ++i){
            index = r.nextInt(chartable.size());
            stringBuilder.append(chartable.get(index));
        }
        index = r.nextInt(5);
        int num = r.nextInt(10);
        stringBuilder.insert(index,String.valueOf(num));
        return stringBuilder.toString();
    }
}
/*c123
123
123
320803200611272819
111111111118*/