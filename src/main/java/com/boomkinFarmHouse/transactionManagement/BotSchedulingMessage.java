package com.boomkinFarmHouse.transactionManagement;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@EnableScheduling
public class BotSchedulingMessage {

    private final RestTemplate restTemplate;

    public BotSchedulingMessage(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron= "0 0/1 *  * * ? ")
    public void sendMessage() {

        String urlG2g = "https://sls.g2g.com/offer/search?service_id=lgc_service_1&brand_id=lgc_game_29076&region_id=dfced32f-2f0a-4df5-a218-1e068cfadffa&page_size=48&currency=IDR&country=ID";

        ResponseEntity<BaseResponseG2g<ListPriceResponse>> data = restTemplate.exchange(urlG2g,
                HttpMethod.GET, null, new ParameterizedTypeReference<BaseResponseG2g<ListPriceResponse>>() {
                });

        List<PricesResponse> payload = data.getBody().getPayload().getResults();

        List<String> messages = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current Lowest Prices : ");
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (PricesResponse pricesResponse : payload) {
            log.info("prices :{}", pricesResponse.getDisplayPrice());

             String sb =  pricesResponse.getTitle() +
                    " : " + pricesResponse.getDisplayPrice() +
                    "\n";
             stringBuilder.append(sb);
        }

        String url = "https://api.telegram.org/bot1946338047:AAGD7La5d7EjNNdMEXXNDh8_3Tu-ptPsYH0/sendMessage";
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("chat_id", "478115442")
                .queryParam("text", messages);

        List<String> ids = new ArrayList<>();
        ids.add("1235580653");
        ids.add("478115442");

        for (String id : ids) {
            ResponseEntity<String> customer = restTemplate.exchange(url+"?chat_id="+id+"&text="+stringBuilder.toString(),
                    HttpMethod.GET, null, String.class);
        }

    }

    public  void getData() throws IOException {
        Document document = Jsoup.
                connect("").get();

        var table = document.getElementsByClass("text-body2 text-label");

        System.out.println(table);
    }

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.
                connect("https://www.g2g.com/offer/Bigglesworth-TBC--US----Alliance?service_id=lgc_service_1&brand_id=lgc_game_29076&region_id=dfced32f-2f0a-4df5-a218-1e068cfadffa&filter_attributes=%257B%2522lgc_29076_platform%2522%253A%255B%2522lgc_29076_platform_41166%2522%255D%257D&attributes=%257B%2522lgc_29076_platform%2522%253A%255B%2522lgc_29076_platform_41166%2522%255D%257D&sort=recommended&include_offline=1").get();

        //System.out.println(document);

        var table = document.select("offers-prices-total");

        List<Element> elements = document.select("span.offer-price-amount");

        List<Element> sellers = document.select("div.seller__name-detail seller-name-offer");

        System.out.println(elements.toString());
        System.out.println(sellers.toString());
    }
}
