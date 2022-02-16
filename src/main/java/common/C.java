package common;

import mapper.NumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date 2021/4/27
 */
//@Component
public class C {
    @Autowired
    private NumberMapper numberMapper;

    @PostConstruct
    public void main(){
        List<Number> numbers = numberMapper.selectList(null);

        List<List<Integer>> number = new ArrayList<>();

        for (Number n : numbers){
            List<Integer> a = new ArrayList<>();
            a.add(n.getRed1());
            a.add(n.getRed2());
            a.add(n.getRed3());
            a.add(n.getRed4());
            a.add(n.getRed5());
            a.add(n.getRed6());
            number.add(a);
        }

        List<Integer> one = new ArrayList<Integer>(){{add(1);add(11);add(21);add(31);}};
        List<Integer> two = new ArrayList<Integer>(){{add(2);add(12);add(22);add(32);}};
        List<Integer> three = new ArrayList<Integer>(){{add(3);add(13);add(23);add(33);}};
        List<Integer> four = new ArrayList<Integer>(){{add(4);add(14);add(24);}};
        List<Integer> five = new ArrayList<Integer>(){{add(5);add(15);add(25);}};
        List<Integer> six = new ArrayList<Integer>(){{add(6);add(16);add(26);}};
        List<Integer> seven = new ArrayList<Integer>(){{add(7);add(17);add(27);}};
        List<Integer> eight = new ArrayList<Integer>(){{add(8);add(18);add(28);}};
        List<Integer> nine = new ArrayList<Integer>(){{add(9);add(19);add(29);}};
        List<List<Integer>> test  = new ArrayList<List<Integer>>(){{add(one);add(two);add(three);
            add(four);add(five);add(six);add(seven);add(eight);add(nine);}};
        List<List<Integer>> result  = new ArrayList<>();
        for (List<Integer> a:number){
            boolean flag = false;
            exa:for (List<Integer> b:test){
                for (int i = 0;i<b.size();i++){
                    if (i == 0){
                        if (a.contains(b.get(i))){
                            flag = true;
                        }
                    }
                    if (flag){
                        if (!a.contains(b.get(i))){
                            flag = false;
                        }
                    }
                }
                if (flag){
                    result.add(a);
                    break exa;
                }
            }
        }

        System.out.println(result.toString());
    }

}
