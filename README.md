# cardealer
cardealer
## use cacse API:
cURL commands for each of the API endpoints.

1. GET all cars:
```bash
curl -X GET http://localhost:8080/api/cars
```

2. POST a new car:
```bash
curl -X POST http://localhost:8080/api/cars \
  -H "Content-Type: application/json" \
  -d '{
    "make": "Toyota",
    "model": "Camry",
    "year": 2023,
    "length": 4.9,
    "weight": 1580.0,
    "velocity": 180,
    "color": "Silver",
    "price": 29999.99
  }'
```

3. GET (search cars):
```bash
curl -X GET "http://localhost:8080/api/cars/search?make=Toyota&year=2023"
```
This example searches for Toyota cars from 2023. You can adjust the query parameters as needed.

4. GET (download cars as XML):
```bash
curl -X GET "http://localhost:8080/api/cars/download?make=Toyota" -H "Accept: application/xml" --output cars.xml
```
This command will download the XML file and save it as `cars.xml` in your current directory. You can modify the query parameters to filter the cars included in the XML.

5. GET a specific car by ID:
```bash
curl -X GET http://localhost:8080/api/cars/1
```
Replace `1` with the actual ID of the car you want to retrieve.
