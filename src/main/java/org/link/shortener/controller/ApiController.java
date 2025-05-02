package org.link.shortener.controller;


import org.link.shortener.model.StatisticsDTO;
import org.link.shortener.model.UrlRequestDTO;
import org.link.shortener.model.UrlResponseDTO;
import org.link.shortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private UrlShortenerService urlShortenerService;

    @Autowired
    public ApiController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/shorten/{code}")
    public ResponseEntity<UrlResponseDTO> getUrl(@PathVariable String code){
        UrlResponseDTO urlResponseDTO = urlShortenerService.getUrl(code);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(urlResponseDTO);
    }

    @GetMapping("/shorten/{code}/stats")
    public ResponseEntity<StatisticsDTO> getUrlStats(@PathVariable String code){
        StatisticsDTO statisticsDTO = urlShortenerService.getUrlStats(code);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(statisticsDTO);
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDTO> shortenUrl(
            @RequestBody UrlRequestDTO urlRequestDTO
            )
    {
        UrlResponseDTO urlResponseDTO = urlShortenerService.addUrl(urlRequestDTO);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(urlResponseDTO);
    }

    @PutMapping("/shorten/{code}")
    public ResponseEntity<UrlResponseDTO> changeUrl(
            @RequestBody UrlRequestDTO urlRequestDTO,
            @PathVariable String code
            )
    {
        UrlResponseDTO urlResponseDTO = urlShortenerService.changeUrl(urlRequestDTO, code);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(urlResponseDTO);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteUrl(
            @PathVariable String code
    ){
        urlShortenerService.deleteUrl(code);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }

}
