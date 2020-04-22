package pers.yaodi.stream;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <Description> 用来测试stream流的主类 <br>
 *
 * @author 妖帝艾雷诺 <br>
 * @version 1.0 <br>
 * @createDate 2020/04/21 22:32 <br>
 * @see pers.yaodi.stream <br>
 */
public class Main {

    public static void main(String[] args) {


        //region 构建

        //Collection接口
        //new一个普通list对象
        List<Integer> list = new ArrayList<Integer>() {{ add(1);add(2);add(3); }};
        //调用默认方法stream转化成Stream流
        list.stream();

        //Stream.of
        //Stream.of用元素直接构建流
        Stream.of (1,2,3);

        //endregion

        //region 操作

        //中间操作和最终操作
        System.out.println(list.stream()
                //中间操作
                .filter(num -> num > 1)
                //最终操作
                .count());

        //endregion

        //region 常用方法

        //collect()
        System.out.println(list.stream().collect(Collectors.toList()));

        //map()
        System.out.println(list.stream()
                .map((num)->Integer.toString(num))
                .collect(Collectors.toList()));

        //flatMap()
        Stream.of("Hello World")
                .map(str->str.split(""))
                .distinct()
                .collect(Collectors.toList())
                .forEach((strArray) -> System.out.println(Arrays.toString(strArray)));

        System.out.println(Arrays.toString(Stream.of("Hello World")
                .map(str->str.split(""))
                .flatMap(Stream::of)
                .distinct()
                .collect(Collectors.toList()).toArray()));;

        //reduce()
        System.out.println(Stream.of(1, 2, 3) .reduce(0, (acc, element) -> acc + element));

        //parallel()

        Long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(IntStream.range(0, 1000000000)
                .parallel()
                .summaryStatistics()
                .getSum());

        Long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(String.format("运行时间为：%sms",endTime- startTime));

        //endregion
    }

}
