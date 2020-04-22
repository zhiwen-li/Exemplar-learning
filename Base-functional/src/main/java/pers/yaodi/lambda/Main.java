package pers.yaodi.lambda;

import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <Description> 主方法类，用于测试 <br>
 *
 * @author lizhiwen <br>
 * @version 1.0 <br>
 * @createDate 2020/04/20 17:03 <br>
 */
public class Main {

    public static void main(String[] args) {

        //region 长度举例
        System.out.println(Stream.of("我长","我才长","你两都没有我长").mapToInt(String::length).summaryStatistics().getMax());
        //endregion


        //region lambda表达式+自定义函数式接口+方法引用

        //匿名内部类表示
        /*
        CheGuevara cheGuevara = new CheGuevara() {
            @Override
            public void notWork() {
                System.out.println("这辈子都不可能打工的！！！");
            }
        };
        */

        //无参
        //CheGuevara cheGuevara = ()-> System.out.println("这辈子都不可能打工的！！！");

        //单参数
        //CheGuevara cheGuevara = (electromobile)-> System.out.println("这辈子都不可能打工的！！！ 我只想拿【"+electromobile+"】");

        //多参数
        //CheGuevara cheGuevara = (electromobile, bicycle)-> System.out.println("这辈子都不可能打工的！！！ 我想拿【"+electromobile+"】和拿【"+bicycle+"】");

        //实现多行
        /*
        CheGuevara cheGuevara = (electromobile, bicycle)-> {
            System.out.println("这辈子都不可能打工的！！！");
            System.out.println("我想拿【"+electromobile+"】");
            System.out.println("还要拿【"+bicycle+"】");
        };
        */

        //带类型
        /*
        CheGuevara cheGuevara = (String electromobile, String bicycle)-> {
            System.out.println("这辈子都不可能打工的！！！");
            System.out.println("我想拿【"+electromobile+"】");
            System.out.println("还要拿【"+bicycle+"】");
        };
        */


        //方法引用(多参数)
        //CheGuevara cheGuevara = CheGuevara::staticNotWork;

        //具体执行
        //cheGuevara.notWork("某某牌电动车", "某某牌自行车");

        //endregion


        //region 内置函数式接口

        //Supplier<T>
        //利用Supplier定义一个的"窃.格瓦拉",用方法引用简化new操作
        Supplier<CheGuevaraImpl> cheGuevaraSupplier = CheGuevaraImpl::new;

        //Consumer<T>
        //定义一个消费行为，怎么消费的（惰性，还未执行）
        Consumer<CheGuevaraImpl> cheGuevaraImplConsumer = cheGuevaraImpl1 -> {
            System.out.println("花了一百块钱，买醉。没钱了！！！");
        };

        //接收Supplier提供的一个具体的"窃.格瓦拉"，然后作为消费者，进行真实消费
        cheGuevaraImplConsumer.accept(cheGuevaraSupplier.get());

        //Function<T,R>
        Function<CheGuevaraImpl, String> cheGuevaraStringFunction = cheGuevaraImpl2->{
            //输入消费(利用上面定义的消费行为，对当前输入的"窃.格瓦拉"进行接收)
            cheGuevaraImplConsumer.accept(cheGuevaraImpl2);
            //输出
            return "吐了";
        };

        //接收Supplier提供的一个具体的"窃.格瓦拉"，然后作为消费者，进行真实消费,并输出
        String output = cheGuevaraStringFunction.apply(cheGuevaraSupplier.get());
        System.out.println(output);

        //Predicate<T>
        Predicate<Integer> integerPredicate = x-> x > 100;
        System.out.println("50 > 100 = "+integerPredicate.test(50));

        //endregion

    }

}
