package com.skodin.controllers;

import com.skodin.DTO.DataDTO;
import com.skodin.DTO.DataTestOptionsDTO;
import com.skodin.models.Data;
import com.skodin.models.test.DataTestOptions;
import com.skodin.service.KafkaDataService;
import com.skodin.service.TestDataService;
import com.skodin.util.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    private final ModelMapper mapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDTO dataDto) {
        Data data = mapper.getData(dataDto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDTO testOptionsDto) {
        DataTestOptions testOptions = mapper.getDataTestOptions(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
