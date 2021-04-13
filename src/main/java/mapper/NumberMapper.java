package mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import common.Number;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yb
 * @date 2021/4/12
 */
@Mapper
public interface NumberMapper extends BaseMapper<Number> {
    @Select("select count(*) from number where red#{a} = #{b}")
    int aa(@Param("a")Integer a,@Param("b")Integer b);

    @Select("select count(*) from number where blue = #{a}")
    int bb(@Param("a")Integer a);

    @Select("select count(*) from number where red1 = #{a} or red2 = #{a} or red3 = #{a} or red4 = #{a} or red5 = #{a} or red6 = #{a}")
    int cc(@Param("a")Integer a);
}
