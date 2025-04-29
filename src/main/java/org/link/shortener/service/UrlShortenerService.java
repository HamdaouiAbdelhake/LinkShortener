package org.link.shortener.service;

import jakarta.transaction.Transactional;
import org.link.shortener.exception.UrlNotFound;
import org.link.shortener.model.StatisticsDTO;
import org.link.shortener.model.Url;
import org.link.shortener.model.UrlRequestDTO;
import org.link.shortener.model.UrlResponseDTO;
import org.link.shortener.repository.UrlRepository;
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
                .orElseThrow(()->new UrlNotFound());
        url.setUseCount(url.getUseCount() + 1);
        urlRepository.save(url);
        return new UrlResponseDTO(
                url.getId(),
                url.getCode(),
                url.getLink(),
                url.getCreatedAt(),
                url.getUpdatedAt()
        );
    }

    public StatisticsDTO getUrlStats(String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFound());;
        return new StatisticsDTO(
                url.getId(),
                url.getCode(),
                url.getLink(),
                url.getCreatedAt(),
                url.getUpdatedAt(),
                url.getUseCount()
        );
    }

    @Transactional
    public void addUrl(UrlRequestDTO newUrl){
        String code = "";
        Url url = new Url(
                newUrl.getUrl(),
                code,
                0,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        urlRepository.save(url);
    }

    @Transactional
    public void changeUrl(UrlRequestDTO newUrl, String code){

        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFound());
        url.setLink(newUrl.getUrl());
        urlRepository.save(url);
    }

    @Transactional
    public void deleteUrl(String code){
        Url url = urlRepository.findUrlByCode(code)
                .orElseThrow(()->new UrlNotFound());
        urlRepository.delete(url);
    }
}
