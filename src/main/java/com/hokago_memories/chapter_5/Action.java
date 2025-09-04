package com.hokago_memories.chapter_5;

@FunctionalInterface
public interface Action {
    void execute(Facts facts);
}
