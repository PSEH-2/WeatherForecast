package com.sapeint.assessment.weather.controller;

import com.sapeint.assessment.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestController
@RequestMapping("/v1")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/welcome")
    public String welcome() {

        return weatherService.getXMessage();
    }

    @GetMapping(value = "/{city}", produces = "application/json")
    public String getCityWeather(@PathVariable("city") String city) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = weatherService.getWeather(city);
        } catch (HttpClientErrorException hce) {
            jsonObject.put("message", hce.getStatusText());
            jsonObject.put("status", hce.getRawStatusCode());
        } catch (Exception e) {
            log.error("Exception occurred while fetching weather forecast data", e);
            jsonObject.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return jsonObject.toString();
    }

    @GetMapping(value = "/advise/{city}", produces = "application/text")
    public String getCityWeatherAdvice(@PathVariable("city") String city) {

        JSONObject jsonObject = new JSONObject();
        String advice = "Happ days out there";
        try {
             advice = weatherService.getWeatherAdvice(city);
        } catch (HttpClientErrorException hce) {
            jsonObject.put("message", hce.getStatusText());
            jsonObject.put("status", hce.getRawStatusCode());
        } catch (Exception e) {
            log.error("Exception occurred while fetching X data", e);
            jsonObject.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return advice;
    }
}
