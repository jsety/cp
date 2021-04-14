package common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mapper.NumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yb
 * @date 2021/4/14
 */
@Component
public class A {

    @Autowired
    private NumberMapper numberMapper;

//    @PostConstruct
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
}
