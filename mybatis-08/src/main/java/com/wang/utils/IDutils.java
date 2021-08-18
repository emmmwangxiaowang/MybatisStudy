package com.wang.utils;

import org.junit.Test;
import java.util.UUID;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/8/17 0017
 */


public class IDutils
{
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
    }

}
