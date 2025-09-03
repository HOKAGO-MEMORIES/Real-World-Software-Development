package com.hokago_memories.chapter_4;

import static com.hokago_memories.chapter_4.Attributes.PATH;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 도메인 클래스로 텍스트 파일 모델링
class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    TextFile(final File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        lines = Files.lines(file.toPath()).collect(toList());
    }

    Map<String, String> getAttributes() {
        return attributes;
    }

    int addLines() {

    }

    void addLineSuffix(final String prefix, final String attributeName) {

    }
}
