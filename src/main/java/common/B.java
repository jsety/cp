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
//            System.out.println(index[i] +"出现的次数："+ counts[i]);
        }



        int m = 1;
        while (m <= 2){
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
//                System.out.println("第"+i+"注："+a+"    "+b+"    "+c+"    "+d+"    "+e+"    "+f+"    "+g);
                    i = i+1;
                }else {
                }
                integers.clear();
            }
            int[] aa = new int[33];
            int[] bb = new int[33];
            for (int j = 0;j<33;j++){
                aa[j] = j+1;
                bb[j] = map.get(j+1);
            }
            for (int x = 0;x<33;x++){
                for (int y = 0;y<32;y++){
                    if (bb[y] < bb[y+1]){
                        int temp = bb[y];
                        bb[y] = bb[y+1];
                        bb[y+1] = temp;
                        int temp2 = aa[y];
                        aa[y] = aa[y+1];
                        aa[y+1] = temp2;
                    }
                }
            }
            int[] cc = new int[16];
            int[] dd = new int[16];
            for (int j = 0;j<16;j++){
                cc[j] = j+1;
                dd[j] = map2.get(j+1);
            }
            for (int x = 0;x<16;x++){
                for (int y = 0;y<15;y++){
                    if (dd[y] < dd[y+1]){
                        int temp = dd[y];
                        dd[y] = dd[y+1];
                        dd[y+1] = temp;
                        int temp2 = cc[y];
                        cc[y] = cc[y+1];
                        cc[y+1] = temp2;
                    }
                }
            }

            Map<Integer,List<Integer>> aaa = new HashMap<>();
            for(int l =0;l<bb.length;l++){
                List<Integer> aaaa = aaa.get(bb[l]);
                if(aaaa == null){
                    aaaa = new ArrayList<>();
                }
                aaaa.add(aa[l]);
                aaa.put(bb[l],aaaa);
            }
            List<Integer> as = new ArrayList<>();
            int jk = 0;
            for(int l = 0;l<10;l++){
                if (as.size() < 6){
                    if (l == 0){
                        jk = bb[0];
                    }else {
                        jk = jk - 1;
                    }
                    if (aaa.get(jk) == null){
                        continue;
                    }
                    if (as.size() + aaa.get(jk).size() <= 6){
                        as.addAll(aaa.get(jk));
                    }else if (as.size() + aaa.get(jk).size() > 6){
                        while (as.size() < 6){
                            int asd = r.nextInt(aaa.get(jk).size());
                            while(as.contains(aaa.get(jk).get(asd))) {
                                asd = r.nextInt(aaa.get(jk).size());
                            }
                            as.add(aaa.get(jk).get(asd));
                        }
                    }
                }
            }


            List<Integer> sad = new ArrayList<>();
            sad.add(cc[0]);
            for (int k = 1;k < cc.length;k++){
                if (dd[k] == dd[k-1]){
                    sad.add(cc[k]);
                }else {
                    break;
                }
            }

            int asd = r.nextInt(sad.size());
            as.add(sad.get(asd));

            QueryWrapper<Number> wrapper = new QueryWrapper<>();
            wrapper.eq("red1",as.get(0))
                    .eq("red2",as.get(1))
                    .eq("red3",as.get(2))
                    .eq("red4",as.get(3))
                    .eq("red5",as.get(4))
                    .eq("red6",as.get(5))
                    .eq("blue",cc[0]);
            List<Number> number = numberMapper.selectList(wrapper);


            if (number.size() == 0){
                System.out.println("第一注："+as.get(0)+"   "+as.get(1)+"   "+as.get(2)+"   "+as.get(3)+"   "+as.get(4)+"   "+as.get(5)+"   "+cc[0]);
                m += 1;
            }
        }
    }

}
