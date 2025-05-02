package org.link.shortener.service;


import org.apache.coyote.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.link.shortener.exception.UrlNotFoundException;
import org.link.shortener.model.StatisticsDTO;
import org.link.shortener.model.Url;
import org.link.shortener.model.UrlRequestDTO;
import org.link.shortener.model.UrlResponseDTO;
import org.link.shortener.repository.UrlRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UrlShortenerServiceUnitTests {

    @InjectMocks
    private UrlShortenerService urlShortenerService;

    @Mock
    private UrlRepository urlRepository;

    @Test
    @DisplayName("getUrl method test of a happy flow")
    public void getUrlTest1() {
        //Arrange
        Url url = new Url("Random", "RandomCode", 0L, LocalDateTime.now(), LocalDateTime.now());
        when(urlRepository.findUrlByCode("RandomCode")).thenReturn(Optional.of(url));
        // Act
        UrlResponseDTO response = urlShortenerService.getUrl("RandomCode");
        // Assert
        verify(urlRepository).save(url);
        assertEquals("RandomCode", response.getCode());
        assertEquals("Random", response.getUrl());
        assertEquals(1L, url.getUseCount());
    }

    @Test
    @DisplayName("getUrl method test of a exception flow")
    public void getUrlTest2() {
        //Arrange
        Url url = new Url("Random", "RandomCode", 0L, LocalDateTime.now(), LocalDateTime.now());
        when(urlRepository.findUrlByCode("RandomCode")).thenReturn(Optional.empty());
        // Assert
        assertThrows(UrlNotFoundException.class, ()-> urlShortenerService.getUrl("RandomCode"));
        verify(urlRepository,never()).save(url);
    }

    @Test
    @DisplayName("getUrl method test of a happy flow")
    public void getUrlStatsTest1() {
        //Arrange
        Url url = new Url("Random", "RandomCode", 0L, LocalDateTime.now(), LocalDateTime.now());
        when(urlRepository.findUrlByCode("RandomCode")).thenReturn(Optional.of(url));
        // Act
        StatisticsDTO response = urlShortenerService.getUrlStats("RandomCode");
        // Assert
        assertEquals("RandomCode", response.getCode());
        assertEquals("Random", response.getUrl());
        assertEquals(0L, response.getUseCount());
    }

    @Test
    @DisplayName("getUrl method test of a exception flow")
    public void getUrlStatsTest2() {
        //Arrange
        Url url = new Url("Random", "RandomCode", 0L, LocalDateTime.now(), LocalDateTime.now());
        when(urlRepository.findUrlByCode("RandomCode")).thenReturn(Optional.empty());
        // Assert
        assertThrows(UrlNotFoundException.class, ()-> urlShortenerService.getUrlStats("RandomCode"));
    }

}
