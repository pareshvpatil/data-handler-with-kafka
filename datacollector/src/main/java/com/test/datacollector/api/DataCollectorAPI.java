package com.test.datacollector.api;


import com.test.datacollector.models.api.DataCollectorRequest;
import com.test.datacollector.models.api.DataCollectorResponse;
import com.test.datacollector.service.DataCollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataCollectorAPI {

    private final DataCollectorService dataCollectorService;

    @PostMapping(path = "/device-data",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataCollectorResponse> collectDeviceData(@RequestBody @Valid DataCollectorRequest dataCollectorRequest) {
        return new ResponseEntity<>(dataCollectorService.collect(dataCollectorRequest), HttpStatus.ACCEPTED);
    }
}
