package common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mapper.NumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yb
 * @date 2021/4/12
 */
@Service
public class NumberService {

    @Autowired
    private NumberMapper numberMapper;
    @Autowired
    private WebClient webClient;

//    @PostConstruct
//    public void main(){
//        String response = webClient.get().uri("https://datachart.500.com/ssq/zoushi/newinc/jbzs_redblue.php?expect=1000000").retrieve().bodyToMono(String.class).block();
//        String[] s = response.split("\n");
//        List<String> ls = Arrays.asList(s);
//        List<String> lss = new ArrayList<>();
//        List<String> lsss = new ArrayList<>();
//        List<String> lssss = new ArrayList<>();
//        for (String str : ls){
//            lss.add(str);
//        }
//
//        for (String str : lss){
//            if (str.contains("<td align=\"center\">") || str.contains("<td class=\"chartBall01\">") || str.contains("<td class=\"chartBall02\">")){
//                lsss.add(str);
//            }
//        }
//        lsss.remove(5364);
//        lsss.remove(5364);
//        lsss.remove(5364);
//        String str = "";
//        for (int i = 0;i<lsss.size();i++){
//            if (i % 2 == 0){
//                str = lsss.get(i);
//            }else {
//                str = str + lsss.get(i);
//                lssss.add(str);
//                str = "";
//            }
//        }
//
//        for (String str1:lssss){
//            String[] a = str1.split("</td>");
//            List<String> aa = Arrays.asList(a);
//            List<String> aaa = new ArrayList<>();
//            for (String b :aa){
//                if (b.contains("center") || b.contains("chartBall01") || b.contains("chartBall02")){
//                    aaa.add(b);
//                }
//            }
//            Number number = new Number();
//            number.setIndexDate(aaaaaaa(aaa.get(0)));
//            number.setRed1(Integer.valueOf(aaaaaaa(aaa.get(1))));
//            number.setRed2(Integer.valueOf(aaaaaaa(aaa.get(2))));
//            number.setRed3(Integer.valueOf(aaaaaaa(aaa.get(3))));
//            number.setRed4(Integer.valueOf(aaaaaaa(aaa.get(4))));
//            number.setRed5(Integer.valueOf(aaaaaaa(aaa.get(5))));
//            number.setRed6(Integer.valueOf(aaaaaaa(aaa.get(6))));
//            number.setBlue(Integer.valueOf(aaaaaaa(aaa.get(7))));
//            numberMapper.insert(number);
//        }
//
//    }
//
//    public String aaaaaaa(String a){
//        String[] aa = a.split(">");
//        return aa[1];
//    }
//
//
//    @PostConstruct
//    public void main(){
//        for (int i = 1;i<= 6;i++){
//            for (int j = 1;j<=33;j++){
//                int count = numberMapper.aa(i,j);
//                System.out.println("red" + i +"出现" + j +"的次数："+ count);
//            }
//        }
//        for (int i = 1 ;i<=16;i++){
//            int count = numberMapper.bb(i);
//            System.out.println("blue出现" + i +"的次数："+ count);
//        }
//    }
//
    @PostConstruct
    public void main(){
        List<Integer> integers = new ArrayList<>();

        Random r = new Random();
        int i = 1;
        while (i<= 10){
            int a = r.nextInt(5) + 1;
            integers.add(a);
            int b = a;
            while (integers.contains(b)){
                b = r.nextInt(7)+4;
            }
            integers.add(b);
            int c = b;
            while (integers.contains(c)){
                c = r.nextInt(9) + 10;
            }
            integers.add(c);
            int d = c;
            while (integers.contains(d)){
                d = r.nextInt(7) + 17;
            }
            integers.add(d);
            int e = d;
            while (integers.contains(e)){
                e = r.nextInt(9) + 22;
            }
            integers.add(e);
            int f = e;
            while (integers.contains(f)){
                f = r.nextInt(8) +26;
            }
            integers.add(f);
            int g = r.nextInt(16) + 1;
            integers.add(g);

            QueryWrapper<Number> wrapper = new QueryWrapper<>();
            wrapper.eq("red1",a)
                    .eq("red2",b)
                    .eq("red3",c)
                    .eq("red4",d)
                    .eq("red5",e)
                    .eq("red6",f)
                    .eq("blue",g);
            List<Number> number = numberMapper.selectList(wrapper);
            if (number.size()>0){
            }else {
                System.out.println("第"+i+"注："+a+"    "+b+"    "+c+"    "+d+"    "+e+"    "+f+"    "+g);
                i = i+1;
            }
            integers.clear();
        }
    }
//    @PostConstruct
//    public void main(){
//        int[] counts = new int[33];
//        int[] index = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
//        for (int i = 1 ;i<=33;i++){
//            int count = numberMapper.cc(i);
//            counts[i-1] = count;
////            System.out.println(i +"出现的次数："+ count);
//        }
//
//        for (int i = 0;i<33;i++){
//            for (int j = 0;j<32;j++){
//                if (counts[j] < counts[j+1]){
//                    int temp = counts[j];
//                    counts[j] = counts[j+1];
//                    counts[j+1] = temp;
//
//                    int temp2 = index[j];
//                    index[j] = index[j+1];
//                    index[j+1] = temp2;
//                }
//            }
//        }
//
//        for (int i = 0;i<33;i++){
//            System.out.println(index[i] +"出现的次数："+ counts[i]);
//        }
//
//    }
}