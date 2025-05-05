# Build and Run

## output of "mvn clean install"

```
```

## output of "mvn spring-boot:run"

```
```

# Testing

## Manual tests report

- Returns round scores in CSV format in response to a text/csv request: PASSED

## Manual testing protocol

```
curl -s -v -u 1:1 --header 'accept: text/csv' http://localhost:8082/round-score

...PLACE_OUTPUT_HEARE...
```