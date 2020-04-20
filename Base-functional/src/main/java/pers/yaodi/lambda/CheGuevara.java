package pers.yaodi.lambda;

/**
 * <Description> “精神领袖”——“窃.格瓦拉”,用于展示函数式接口，不打工是我们唯一的抽象方法 <br>
 * @author 妖帝艾雷诺 <br>
 * @version 1.0 <br>
 * @createDate 2020/04/20 16:42 <br>
 */
@FunctionalInterface
public interface CheGuevara {

    /**
     * 不打工 (没有参数)
     */
    //void notWork();

    /**
     * 不打工 (单参数)
     * @param electromobile 电瓶车
     */
    //void notWork(String electromobile);

    /**
     * 不打工（多参数）
     * @param electromobile 电瓶车
     * @param bicycle 自行车
     */
    void notWork(String electromobile, String bicycle);

    /**
     * 不打工（Java8接口静态方法，用于展示“方法引用”, 不一定非要在这个接口写实现方法，也可以用其他类）
     * @param electromobile 电瓶车
     */
    static void staticNotWork(String electromobile, String bicycle){
        System.out.println("这辈子都不可能打工的！！！我想拿【"+electromobile+"】和拿【"+bicycle+"】");
    }

}
