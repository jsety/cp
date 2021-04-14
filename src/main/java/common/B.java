package common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mapper.NumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yb
 * @date 2021/4/14
 */

@Component
public class B {

    @Autowired
    private NumberMapper numberMapper;

    @PostConstruct
    public void main(){
        Random r = new Random();
        List<Integer> integers = new ArrayList<>();
        int[] counts = new int[33];
        int[] index = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        for (int i = 1 ;i<=33;i++){
            int count = numberMapper.cc(i);
            counts[i-1] = count;
        }

        for (int i = 0;i<33;i++){
            for (int j = 0;j<32;j++){
                if (counts[j] < counts[j+1]){
                    int temp = counts[j];
                    counts[j] = counts[j+1];
                    counts[j+1] = temp;

                    int temp2 = index[j];
                    index[j] = index[j+1];
                    index[j+1] = temp2;
                }
            }
        }

        for (int i = 0;i<33;i++){
            System.out.println(index[i] +"出现的次数："+ counts[i]);
        }



        int i = 1;

        Map<Integer,Integer> map = new HashMap<>();
        for (int j=1;j<=33;j++){
            map.put(j,0);
        }
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int j=1;j<=16;j++){
            map2.put(j,0);
        }

        while (i<= 10){

            int z = r.nextInt(13);
            int y = r.nextInt(13);
            int x = r.nextInt(20) + 13;
            int u = r.nextInt(20) + 13;
            int v = r.nextInt(20) + 13;
            int w = r.nextInt(20) + 13;

            int a = index[z];
            int b = index[y];
            int c = index[x];
            int d = index[u];
            int e = index[v];
            int f = index[w];

            int g = r.nextInt(16) + 1;
            integers.add(a);
            integers.add(b);
            integers.add(c);
            integers.add(d);
            integers.add(e);
            integers.add(f);
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

            int old = integers.size();
            int n = integers.stream().distinct().collect(Collectors.toList()).size();
            if (number.size() == 0 && old == n){
                map.put(a,map.get(a)+1);
                map.put(b,map.get(b)+1);
                map.put(c,map.get(c)+1);
                map.put(d,map.get(d)+1);
                map.put(e,map.get(e)+1);
                map.put(f,map.get(f)+1);
                map2.put(g,map.get(g)+1);
                System.out.println("第"+i+"注："+a+"    "+b+"    "+c+"    "+d+"    "+e+"    "+f+"    "+g);
                i = i+1;
            }else {
            }
            integers.clear();
        }
        System.out.println(map.toString());
    }

}
