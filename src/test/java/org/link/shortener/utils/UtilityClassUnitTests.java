package org.link.shortener.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityClassUnitTests {

    @Test
    public void base62EncoderTest(){
        assertEquals("L20000", UtilityClass.base62Encoder(145L));
        assertEquals("4J9k00", UtilityClass.base62Encoder(10998866L));
        assertEquals("5P7v50", UtilityClass.base62Encoder(87494839L));
    }
}
