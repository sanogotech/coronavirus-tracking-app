package com.interviewdot.coronatrackerapp.services;

import com.interviewdot.coronatrackerapp.models.CoronaCaseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CoronaDataService {
    private final String CORONA_INFO_URI = "https://coronavirus-tracker-api.herokuapp.com/all";

    private final RestTemplate restTemplate;

    public CoronaDataService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoronaCaseDTO getCoronaData() {
        CoronaCaseDTO coronaCaseData;

        try {
            coronaCaseData = this.restTemplate.getForObject(CORONA_INFO_URI, CoronaCaseDTO.class);
        } catch (HttpClientErrorException e) {
            System.out.println("issue while getting the corona case data : " + e.getMessage());
            return new CoronaCaseDTO();
        }
        return coronaCaseData;
    }
}
