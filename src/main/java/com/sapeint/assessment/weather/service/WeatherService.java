package com.sapeint.assessment.weather.service;

import org.json.JSONObject;

public interface WeatherService {

    String getXMessage();

    JSONObject getWeather(String city);

    String getWeatherAdvice(String city);
}
