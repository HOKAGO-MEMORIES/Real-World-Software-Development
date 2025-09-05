package com.hokago_memories.chapter_6;

import static java.nio.charset.StandardCharsets.UTF_16;


import org.bouncycastle.crypto.generators.SCrypt;
import java.security.SecureRandom;

class KeyGenerator {
    private static final int SCRYPT_COST = 16384;
    private static final int SCRYPT_BLOCK_SIZE = 8;
    private static final int SCRYPT_PARALLELISM = 1;
    private static final int KEY_LENGTH = 20;

    private static final int SALT_LENGTH = 16;

    private static final SecureRandom secureRandom = new SecureRandom();

    static byte[] hash(final String password, final byte[] salt) {
        final byte[] passwordBytes = password.getBytes(UTF_16);
        return SCrypt.generate(
                passwordBytes,
                salt,
                SCRYPT_COST,
                SCRYPT_BLOCK_SIZE,
                SCRYPT_PARALLELISM,
                KEY_LENGTH);
    }

    // 솔트: 암호 해싱 함수에 적용하는 임의로 생성된 추가 입력
    // 해싱을 되돌리기 위해 해싱 함수와 솔트 두 개를 모두 알도록 요구
    static byte[] newSalt() {
        final byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return salt;
    }
}
