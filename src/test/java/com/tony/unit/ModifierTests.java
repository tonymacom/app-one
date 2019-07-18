package com.tony.unit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/7/18
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
public class ModifierTests {


    private class Class2 {
    }


    protected class Class3 {
    }

    public static final class Class4 {

    }

    protected abstract class Class5 {
    }

    private interface Class6 {
    }
    public interface Class7 {
    }


    public static final String prop = "";

    @Test
    public void log() {
        log.info("ModifierTests modifiers: {}", ModifierTests.class.getModifiers()); // 1
        log.info("Class2 modifiers: {}",Class2.class.getModifiers()); // 2
        log.info("Class3 modifiers: {}",Class3.class.getModifiers()); // 4
        log.info("Class4 modifiers: {}",Class4.class.getModifiers()); // 25 = 1(public) + 8(static) + 16(final)
        log.info("Class5 modifiers: {}",Class5.class.getModifiers()); // 1028 = 4(protected) + 1024(abstract)
        log.info("private interface modifiers: {}",Class6.class.getModifiers()); //1546 = 2(private) + 512(interface) + 1024(abstract) + 8(static)
        log.info("public interface modifiers: {}",Class7.class.getModifiers());  //1545 = 1(public) + 512(interface) + 1024(abstract) + 8(static)

    }

    //输出 "public private", public为1, private为2
    @Test
    public void test1() {
        log.info("{}", Modifier.toString(Modifier.PRIVATE + Modifier.PUBLIC));
    }

    //输出: 7,public protected private
    @Test
    public void test2() {
        int mod = Modifier.constructorModifiers();
        log.info("{},{}",mod,Modifier.toString(mod));
    }

    //输出: 3103,public protected private abstract static final strictfp
    @Test
    public void test3() {
        int mod = Modifier.classModifiers();
        log.info("{},{}" , mod,Modifier.toString(mod));
    }

    //输出: 3087,public protected private abstract static strictfp
    @Test
    public void test4() {
        int mod = Modifier.interfaceModifiers();
        log.info("{},{}" , mod,Modifier.toString(mod));
    }

    //输出: 223,public protected private static final transient volatile
    @Test
    public void test5() {
        int mod = Modifier.fieldModifiers();
        log.info("{},{}" , mod,Modifier.toString(mod));
    }

    //输出 : 3391,public protected private abstract static final synchronized native strictfp
    @Test
    public void test6() {
        int mod = Modifier.methodModifiers();
        log.info("{},{}" , mod,Modifier.toString(mod));
    }

    //输出: 16,final
    //解释: 参数是指方法内的形参, 而非fields
    @Test
    public void test7() {
        int mod = Modifier.parameterModifiers();
        log.info("{},{}" , mod,Modifier.toString(mod));
    }

}
