package com.example.naverapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class NaverApiResponse {
    private List<ItemResponse> items = new ArrayList<>();

    @Getter
    @Setter
    static class ItemResponse {
        private String title;
        private String link;
        private String image;
        private String author;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;
    }
}
