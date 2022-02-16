package common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yb
 * @date 2021/5/29
 */
@Controller
@RequestMapping("yy")
public class D {

    @GetMapping("/er")
    public String A(){
        return "success";
    }
}
