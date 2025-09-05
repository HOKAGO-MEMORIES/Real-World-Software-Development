package com.hokago_memories.chapter_6;

import java.util.Optional;
import java.util.function.Consumer;

// Twoot 객체는 불변이기 때문에 update 기능은 없음
public interface TwootRepository {
    Twoot add(String id, String userId, String content);

    Optional<Twoot> get(String id);

    void delete(Twoot twoot);

    void query(TwootQuery twootQuery, Consumer<Twoot> callback);

    void clear();
}
