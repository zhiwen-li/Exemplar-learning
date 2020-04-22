package pers.yaodi.lambda;

/**
 * <Description> 一位看似忠诚的“窃.格瓦拉”的信仰者 <br>
 *
 * @author 妖帝艾雷诺 <br>
 * @version 1.0 <br>
 * @createDate 2020/04/20 23:12 <br>
 */
public class CheGuevaraImpl implements CheGuevara {

    @Override
    public void notWork(String electromobile, String bicycle) {
        System.out.println("这辈子都不可能打工的,哪怕你连一百块都不给我！！！但我不拿【"+electromobile+"】也不拿【"+bicycle+"】");
    }
}
