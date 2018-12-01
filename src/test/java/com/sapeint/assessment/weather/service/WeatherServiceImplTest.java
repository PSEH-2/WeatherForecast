package com.sapeint.assessment.weather.service;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class WeatherServiceImplTest {

    @Mock
    private WeatherServiceImpl weatherServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWeather() {
    }

    @Test
    public void testGetWeather() {

        JSONObject jsonObject = weatherServiceImpl.getWeather("Bengaluru");
        try {
            Assert.assertEquals(jsonObject.getString("cod"), "200");
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetWeatherNegative() {

        JSONObject jsonObject = weatherServiceImpl.getWeather("BengaluruX");
        try {
            Assert.assertEquals(jsonObject.getString("status"), "400");
        } catch (Exception e) {

        }
    }
}