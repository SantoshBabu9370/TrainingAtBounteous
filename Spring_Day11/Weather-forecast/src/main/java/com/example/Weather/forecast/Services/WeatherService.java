package com.example.Weather.forecast.Services;

import com.example.Weather.forecast.model.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.*;
import org.apache.poi.ss.usermodel.*;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<LocalDate, WeatherForecast> getForecast(String city, Map<String, double[]> coordinatesMap) {
        double[] coords = coordinatesMap.get(city);
        if (coords == null) throw new IllegalArgumentException("Invalid city: " + city);

        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&daily=temperature_2m_max,temperature_2m_min,wind_speed_10m_max&timezone=auto",
                coords[0], coords[1]);

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return parseForecast(response);
    }

    private Map<LocalDate, WeatherForecast> parseForecast(Map<String, Object> json) {
        Map<String, Object> daily = (Map<String, Object>) json.get("daily");
        List<String> dates = (List<String>) daily.get("time");
        List<Double> temperatures = (List<Double>) daily.get("temperature_2m_max");
        List<Double> windSpeeds = (List<Double>) daily.get("wind_speed_10m_max");

        Map<LocalDate, WeatherForecast> forecastMap = new LinkedHashMap<>();
        for (int i = 0; i < dates.size(); i++) {
            WeatherForecast forecast = new WeatherForecast();
            forecast.setDate(LocalDate.parse(dates.get(i)));
            forecast.setTemperature(temperatures.get(i));
            forecast.setWindSpeed(windSpeeds.get(i));
            forecastMap.put(forecast.getDate(), forecast);
        }
        return forecastMap;
    }

    public Map<String, double[]> loadCoordinatesFromExcel(String filePath) throws Exception {
        Map<String, double[]> map = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;
                String city = row.getCell(0).getStringCellValue();
                double lat = row.getCell(1).getNumericCellValue();
                double lon = row.getCell(2).getNumericCellValue();
                map.put(city, new double[]{lat, lon});
            }
        }
        return map;
    }

    public List<String> compareCities(String city1, String city2, Map<String, double[]> coordinatesMap) {
        var forecast1 = getForecast(city1, coordinatesMap);
        var forecast2 = getForecast(city2, coordinatesMap);

        List<String> comparison = new ArrayList<>();
        for (LocalDate date : forecast1.keySet()) {
            WeatherForecast f1 = forecast1.get(date);
            WeatherForecast f2 = forecast2.get(date);

            comparison.add(String.format("Date: %s | %s Temp: %.1f | %s Temp: %.1f",
                    date, city1, f1.getTemperature(), city2, f2.getTemperature()));
        }
        return comparison;
    }
}
