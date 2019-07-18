package com.tony.unit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/7/18
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
public class StrictfpTest {


    double sum, sum_strict;

    double quotient, quotient_strict;

    float aFloat = 0.6710339f;
    double aDouble = 0.04150553411984792d;

    public void test1() {
        sum = aDouble + aFloat;
        quotient = (float)(aFloat / aDouble); // 商
    }

    public strictfp void test2() {
        sum_strict = aDouble + aFloat;
        quotient_strict = (float)(aFloat / aDouble); // 商
    }

    @Test
    public void test() {
        test1();
        test2();
        log.info("aFloat: {}", aFloat);                   //aFloat: 0.6710339
        log.info("aDouble: {}", aDouble);                 //aDouble: 0.04150553411984792
        log.info("sum       : {}", sum);                  //sum       : 0.7125394529774224
        log.info("sum_strict: {}", sum_strict);           //sum_strict: 0.7125394529774224
        log.info("quotient       : {}", quotient);        //quotient       : 16.167335510253906
        log.info("quotient_strict: {}", quotient_strict); //quotient_strict: 16.167335510253906
    }


}
