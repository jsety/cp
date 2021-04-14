package common;

import mapper.NumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yb
 * @date 2021/4/12
 */
@Component
public class NumberService {

    @Autowired
    private NumberMapper numberMapper;
    @Autowired
    private WebClient webClient;

//    拉取历史数据（提前清掉数据库）
//    @PostConstruct
    public void main(){
        String response = webClient.get().uri("https://datachart.500.com/ssq/zoushi/newinc/jbzs_redblue.php?expect=1000000").retrieve().bodyToMono(String.class).block();
        String[] s = response.split("\n");
        List<String> ls = Arrays.asList(s);
        List<String> lss = new ArrayList<>();
        List<String> lsss = new ArrayList<>();
        List<String> lssss = new ArrayList<>();
        for (String str : ls){
            lss.add(str);
        }

        for (String str : lss){
            if (str.contains("<td align=\"center\">") || str.contains("<td class=\"chartBall01\">") || str.contains("<td class=\"chartBall02\">")){
                lsss.add(str);
            }
        }
        lsss.remove(lsss.size()-1);
        lsss.remove(lsss.size()-1);
        lsss.remove(lsss.size()-1);
        String str = "";
        for (int i = 0;i<lsss.size();i++){
            if (i % 2 == 0){
                str = lsss.get(i);
            }else {
                str = str + lsss.get(i);
                lssss.add(str);
                str = "";
            }
        }

        for (String str1:lssss){
            String[] a = str1.split("</td>");
            List<String> aa = Arrays.asList(a);
            List<String> aaa = new ArrayList<>();
            for (String b :aa){
                if (b.contains("center") || b.contains("chartBall01") || b.contains("chartBall02")){
                    aaa.add(b);
                }
            }
            Number number = new Number();
            number.setIndexDate(aaaaaaa(aaa.get(0)));
            number.setRed1(Integer.valueOf(aaaaaaa(aaa.get(1))));
            number.setRed2(Integer.valueOf(aaaaaaa(aaa.get(2))));
            number.setRed3(Integer.valueOf(aaaaaaa(aaa.get(3))));
            number.setRed4(Integer.valueOf(aaaaaaa(aaa.get(4))));
            number.setRed5(Integer.valueOf(aaaaaaa(aaa.get(5))));
            number.setRed6(Integer.valueOf(aaaaaaa(aaa.get(6))));
            number.setBlue(Integer.valueOf(aaaaaaa(aaa.get(7))));
            numberMapper.insert(number);
        }

    }

    public String aaaaaaa(String a){
        String[] aa = a.split(">");
        return aa[1];
    }

}