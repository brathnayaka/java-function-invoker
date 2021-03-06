package com.acme;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

import java.nio.charset.StandardCharsets;

public class CustomInputConverter extends AbstractMessageConverter {


    public CustomInputConverter() {
        super(MimeType.valueOf("custom/type"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return CustomInput.class.equals(clazz);
    }

    @Override
    protected Object convertToInternal(Object payload, MessageHeaders headers, Object conversionHint) {
        return ((CustomInput)payload).data.getBytes(StandardCharsets.UTF_8);
    }
}
