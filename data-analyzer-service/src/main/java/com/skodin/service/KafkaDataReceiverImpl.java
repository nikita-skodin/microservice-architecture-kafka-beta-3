package com.skodin.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skodin.config.LocalDateTimeDeserializer;
import com.skodin.model.Data;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void init() {
        fetch();
    }

    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        localDateTimeDeserializer)
                .create();

        receiver.receive()
                .subscribe(r -> {
                    Data data = gson
                            .fromJson(r.value().toString(), Data.class);
                    kafkaDataService.handle(data);
                    r.receiverOffset().acknowledge();
                });
    }

}