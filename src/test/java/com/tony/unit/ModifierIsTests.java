package com.tony.unit;

import lombok.SneakyThrows;
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
public class ModifierIsTests {

    public static final String id = "";


    @SneakyThrows
    @Test
    public void test() {
        int mod = ModifierIsTests.class.getField("id").getModifiers();
        log.info("{}", Modifier.isPublic(mod)); //true
        log.info("{}", Modifier.isPrivate(mod));//false
        log.info("{}", Modifier.isProtected(mod));//false
        log.info("{}", Modifier.isStatic(mod)); //true
        log.info("{}", Modifier.isFinal(mod));//true
        log.info("{}", Modifier.isSynchronized(mod));//false
        log.info("{}", Modifier.isVolatile(mod));//false
        log.info("{}", Modifier.isTransient(mod));//false
        log.info("{}", Modifier.isNative(mod));//false
        log.info("{}", Modifier.isInterface(mod));//false
        log.info("{}", Modifier.isAbstract(mod)); //false
        log.info("{}", Modifier.isStrict(mod)); //false

    }
}
