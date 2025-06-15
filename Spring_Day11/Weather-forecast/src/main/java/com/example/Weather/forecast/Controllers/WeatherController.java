package com.example.Weather.forecast.Controllers;

import com.example.Weather.forecast.model.WeatherForecast;
import com.example.Weather.forecast.Services.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final Map<String, double[]> cityCoordinates;

    public WeatherController(WeatherService weatherService) throws Exception {
        this.weatherService = weatherService;
        this.cityCoordinates = weatherService.loadCoordinatesFromExcel("city-coordinates.xlsx");
    }

    @GetMapping("/{city}")
    public Map<LocalDate, WeatherForecast> getCityForecast(@PathVariable String city) {
        return weatherService.getForecast(city, cityCoordinates);
    }

    @GetMapping("/compare")
    public List<String> compareForecasts(@RequestParam String city1, @RequestParam String city2) {
        return weatherService.compareCities(city1, city2, cityCoordinates);
    }
}
