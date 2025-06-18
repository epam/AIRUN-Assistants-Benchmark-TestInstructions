# Build and Run

## output of "mvn clean install"

```
```

## output of "mvn spring-boot:run"

```
```

# Testing

## Manual tests report

- The application returns round scores in CSV format in response to a text/csv request: PASSED
- The returned CSV contains only expected headers (Id,Date,Player,HCP,Competition,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,Stroke,Penalty,GrossScore,NetScore,NetScorePar,Stableford): PASSED
- Null values are returned as empty strings: PASSED

## Manual testing protocol

```
curl -s -v -u 1:1 --header 'accept: text/csv' http://localhost:8082/round-score

...PLACE_OUTPUT_HEARE...
```