package com.example.naverapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequestMapping("/api/book-search")
@RequiredArgsConstructor
@RestController
public class NaverApiController {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    private static final String NAVER_CLIENT_ID = "X-Naver-Client-Id";
    private static final String NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";

    @GetMapping
    public ResponseEntity<NaverApiResponse> searchBookByParam(String param) throws UnsupportedEncodingException {
        URI uri = UriComponentsBuilder.fromHttpUrl(naverProperties.getUrl())
                .queryParam("query", param)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .header(NAVER_CLIENT_ID, naverProperties.getClientId())
                .header(NAVER_CLIENT_SECRET, naverProperties.getClientSecret())
                .build();
        log.info("uri : {}", uri);

        return restTemplate.exchange(request, NaverApiResponse.class);
    }
}
