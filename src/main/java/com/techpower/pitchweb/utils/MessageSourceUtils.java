package com.techpower.pitchweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceUtils {
    private static MessageSource messageSource;
    private static final Locale localeVN = new Locale("vi", "VN");

    public MessageSourceUtils() {
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageSourceUtils.messageSource = messageSource;
    }

    public static String getMessage(String key, Object... args) {
        try {
            return messageSource.getMessage(key, args, localeVN);
        } catch (Exception var3) {
            return key;
        }
    }
}
