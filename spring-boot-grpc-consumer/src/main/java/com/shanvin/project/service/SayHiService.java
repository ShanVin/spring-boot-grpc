package com.shanvin.project.service;

import com.shanvin.project.api.SayHiRequest;
import com.shanvin.project.api.SayHiResponse;
import com.shanvin.project.api.SayHiServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SayHiService {

    private static final Logger logger = LoggerFactory.getLogger("ApplicationLogger");

    public String sayHi(String name) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 9041)
                .usePlaintext()
                .build();
        SayHiServiceGrpc.SayHiServiceBlockingStub blockingStub = SayHiServiceGrpc.newBlockingStub(channel);
        SayHiResponse response = blockingStub.sayHi(SayHiRequest.newBuilder()
                .setName(name)
                .build());
        channel.shutdown();
        logger.info("gRPC called sayHi");
        return null != response ? response.getMessage() : null;
    }

}
