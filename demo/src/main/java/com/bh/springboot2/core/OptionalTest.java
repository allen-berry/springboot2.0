package com.bh.springboot2.core;

import java.util.Optional;

/**
 * 测试 Optional用法
 */
public class OptionalTest {
    /**
     * of() 为非 null 的值创建一个 Optional 实例
     * isPresent() 如果值存在，返回 true，否则返回 false
     * get() 返回该对象，有可能返回 null
     */
    public static void main(String[] args) {
        Optional<String> op1 = Optional.of("Hello");
        System.out.println(op1.isPresent()); // 输出 true
        System.out.println(op1.get()); // 输出 Hello
        Optional<String> op2 = Optional.ofNullable(null); // 抛出异常

    }
}
