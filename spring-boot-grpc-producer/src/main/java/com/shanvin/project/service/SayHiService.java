package com.shanvin.project.service;

import com.shanvin.project.api.SayHiRequest;
import com.shanvin.project.api.SayHiResponse;
import com.shanvin.project.api.SayHiServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SayHiService extends SayHiServiceGrpc.SayHiServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger("ApplicationLogger");

    @Override
    public void sayHi(SayHiRequest request, StreamObserver<SayHiResponse> responseObserver) {
        SayHiResponse response = SayHiResponse.newBuilder().setMessage(request.getName() + " say Hi ...").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        logger.info("gRPC called sayHi");
    }

}
