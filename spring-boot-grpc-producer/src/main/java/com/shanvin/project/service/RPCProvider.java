package com.shanvin.project.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RPCProvider {

    private static final Logger logger = LoggerFactory.getLogger("ApplicationLogger");

    @Value("${grpc.port}")
    private int port;

    public void start() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(port)
                .addService(new SayHiService())
                .build()
                .start();
        logger.info("RPCProvider is started on port: {}", port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (null != server) {
                    server.shutdown();
                }
            }
        });

        server.awaitTermination();
    }

}
