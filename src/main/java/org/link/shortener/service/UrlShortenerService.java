package org.link.shortener.service;

import jakarta.transaction.Transactional;
import org.link.shortener.exception.UrlNotFoundException;
import org.link.shortener.model.StatisticsDTO;
import org.link.shortener.model.Url;
import org.link.shortener.model.UrlRequestDTO;
import org.link.shortener.model.UrlResponseDTO;
import org.link.shortener.repository.UrlRepository;
import org.link.shortener.utils.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShortenerService {
    private final UrlRepository urlRepository;

    @Autowired
    public UrlShortenerService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional
    public UrlResponseDTO getUrl(String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFoundException());
        url.setUseCount(url.getUseCount() + 1);
        urlRepository.save(url);
        return new UrlResponseDTO(
                url.getId(),
                url.getLink(),
                url.getCode(),
                url.getCreatedAt(),
                url.getUpdatedAt()
        );
    }

    public StatisticsDTO getUrlStats(String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFoundException());;
        return new StatisticsDTO(
                url.getId(),
                url.getLink(),
                url.getCode(),
                url.getCreatedAt(),
                url.getUpdatedAt(),
                url.getUseCount()
        );
    }

    @Transactional
    public UrlResponseDTO addUrl(UrlRequestDTO newUrl){
        Url url = new Url(
                newUrl.getUrl(),
                "code",
                0L,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        urlRepository.save(url);
        Long id = url.getId();
        String code = UtilityClass.base62Encoder(id);
        url.setCode(code);
        urlRepository.save(url);
        return new UrlResponseDTO(
                url.getId(),
                url.getLink(),
                url.getCode(),
                url.getCreatedAt(),
                url.getUpdatedAt());
    }

    @Transactional
    public UrlResponseDTO changeUrl(UrlRequestDTO newUrl, String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFoundException());
        url.setLink(newUrl.getUrl());
        url.setUpdatedAt(LocalDateTime.now());
        urlRepository.save(url);
        return new UrlResponseDTO(
                url.getId(),
                url.getLink(),
                url.getCode(),
                url.getCreatedAt(),
                url.getUpdatedAt());
    }

    @Transactional
    public void deleteUrl(String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFoundException());
        urlRepository.delete(url);
    }
}
