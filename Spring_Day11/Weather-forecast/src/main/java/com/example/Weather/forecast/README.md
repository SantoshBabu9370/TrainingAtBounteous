# Weather Forecast Comparator

A Spring Boot application that compares the 7-day weather forecasts of two cities using the Open-Meteo API. The application reads city coordinates (latitude and longitude) from an Excel file (`city-coordinates.xlsx`) and uses them to fetch and compare weather data.

---

##  Technologies Used
- Java 21
- Spring Boot
- Spring Web (RestTemplate)
- Gradle


## How to Run the Application

1. Clone the Repository
```bash
git clone https://github.com/your-username/weather-forecast-comparator.git
cd weather-forecast-comparator
```

 1. Place the Excel File
Ensure you have `city-coordinates.xlsx` (sample provided below) placed in the **project root directory**.

 2. Build and Run
./gradlew bootRun


---

## 🌐 API Endpoints

### ✅ Get 7-day forecast for a city
```
GET /weather/{city}
```
Example:
```
GET /weather/Bangalore
```

---

### 🔄 Compare forecasts of two cities
```
GET /weather/compare?city1={city1}&city2={city2}
```
Example:
```
GET /weather/compare?city1=Bangalore&city2=Delhi
```

---

## 📊 Sample Excel File (`city-coordinates.xlsx`)

| City      | Latitude | Longitude |
|-----------|----------|-----------|
| Bangalore | 12.9716  | 77.5946   |
| Delhi     | 28.6139  | 77.2090   |
| Mumbai    | 19.0760  | 72.8777   |
| Chennai   | 13.0827  | 80.2707   |
| Hyderabad | 17.3850  | 78.4867   |

📝 Make sure the file name is exactly: `city-coordinates.xlsx` and placed in the root.

