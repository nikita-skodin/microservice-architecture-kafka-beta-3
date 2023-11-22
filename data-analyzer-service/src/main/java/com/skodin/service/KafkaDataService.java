package com.skodin.service;

import com.skodin.model.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataService {
    public void handle(Data data) {
        log.info("Data object {} was saved", data);
    }

}
