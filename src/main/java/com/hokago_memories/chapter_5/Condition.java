package com.hokago_memories.chapter_5;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
