package com.hokago_memories.chapter_4;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    // 패키지 영역으로 생성자를 제공하고, 시스템이 위치한 패키지에만 접근 권한을 주기 위해 public 사용 안함 (default 사용)
    Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
