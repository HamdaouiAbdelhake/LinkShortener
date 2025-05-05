package org.link.shortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.link.shortener.model.StatisticsDTO;
import org.link.shortener.model.UrlRequestDTO;
import org.link.shortener.model.UrlResponseDTO;
import org.link.shortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class WebController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public WebController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }


    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("contentFragment", "fragments/form.ftl");
        return modelAndView;
    }


    @GetMapping("/{code}")
    public void redirectToUrl(HttpServletResponse response, @PathVariable String code) throws IOException {
        String url = urlShortenerService.getUrl(code).getUrl();
        response.sendRedirect(url);
    }

    @GetMapping("/{code}/stats")
    public ModelAndView urlStats(
            @PathVariable String code
    ) {
        StatisticsDTO statistics = urlShortenerService.getUrlStats(code);
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("statistics", statistics);
        modelAndView.addObject("contentFragment", "fragments/stats.ftl");
        return modelAndView;
    }

    @PostMapping("/shorten")
    public ModelAndView shortenUrl(
            @RequestParam String url
    ) {
        UrlResponseDTO response = urlShortenerService.addUrl(new UrlRequestDTO(url));
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("response" , response);
        modelAndView.addObject("contentFragment", "fragments/shortened.ftl");
        return modelAndView;
    }

    @GetMapping("/get/stats")
    public ModelAndView getStats() {
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("contentFragment", "fragments/stats-form.ftl");
        return modelAndView;
    }

    @PostMapping("/get/stats")
    public void redirectUrlStats(HttpServletResponse response, @RequestParam String code) throws IOException{
        String url = "/" + code + "/stats";
        response.sendRedirect(url);
    }
}

