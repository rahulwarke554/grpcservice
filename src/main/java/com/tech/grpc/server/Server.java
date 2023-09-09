package com.tech.grpc.server;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tech.grpc.StdentServiceGrpc;
import com.tech.grpc.StudentResponse;

@GRpcService
public class Server extends StdentServiceGrpc.StdentServiceImplBase {
	Logger log = LoggerFactory.getLogger(Server.class);
	
	public void getStudent(com.tech.grpc.StudentRequest request,
			io.grpc.stub.StreamObserver<com.tech.grpc.StudentResponse> responseObserver) {
		
		log.info("request =" +request.getId());
		StudentResponse studentResponse = StudentResponse.newBuilder().setAge(25).setName("Rahul").build();

		responseObserver.onNext(studentResponse);
		responseObserver.onCompleted();
	}
}
