package common;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author yb
 * @date 2021/4/12
 */
@TableName("number")
public class Number {
    @TableId
    private Integer indexDate;
    private Integer red1;
    private Integer red2;
    private Integer red3;
    private Integer red4;
    private Integer red5;
    private Integer red6;
    private Integer blue;



    public Integer getRed1() {
        return red1;
    }

    public void setRed1(Integer red1) {
        this.red1 = red1;
    }

    public Integer getRed2() {
        return red2;
    }

    public void setRed2(Integer red2) {
        this.red2 = red2;
    }

    public Integer getRed3() {
        return red3;
    }

    public void setRed3(Integer red3) {
        this.red3 = red3;
    }

    public Integer getRed4() {
        return red4;
    }

    public void setRed4(Integer red4) {
        this.red4 = red4;
    }

    public Integer getRed5() {
        return red5;
    }

    public void setRed5(Integer red5) {
        this.red5 = red5;
    }

    public Integer getRed6() {
        return red6;
    }

    public void setRed6(Integer red6) {
        this.red6 = red6;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Number() {
    }

    public Integer getIndexDate() {
        return indexDate;
    }

    public void setIndexDate(Integer indexDate) {
        this.indexDate = indexDate;
    }

    public Number(Integer indexDate, Integer red1, Integer red2, Integer red3, Integer red4, Integer red5, Integer red6, Integer blue) {
        this.indexDate = indexDate;
        this.red1 = red1;
        this.red2 = red2;
        this.red3 = red3;
        this.red4 = red4;
        this.red5 = red5;
        this.red6 = red6;
        this.blue = blue;
    }
}
