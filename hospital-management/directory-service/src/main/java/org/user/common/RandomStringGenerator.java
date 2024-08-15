package org.user.common;


import java.security.SecureRandom;


import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class RandomStringGenerator implements IdentifierGenerator {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 5;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return "USR" + generateRandomString(RANDOM_STRING_LENGTH);
    }
    

    public static String generateRandomString(int length) {
        StringBuilder randStr = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
}


