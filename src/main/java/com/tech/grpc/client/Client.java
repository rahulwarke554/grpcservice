package com.tech.grpc.client;
import com.tech.grpc.StdentServiceGrpc;
import com.tech.grpc.StudentRequest;
import com.tech.grpc.StudentResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
	static Logger log = LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) {
		
		ManagedChannel mc = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
		
		StdentServiceGrpc.StdentServiceBlockingStub sb = StdentServiceGrpc.newBlockingStub(mc);
		
		StudentResponse sr =  sb.getStudent(StudentRequest.newBuilder().setId(1).build());

		log.info("Response Get =>"+sr.getName() +" "+ sr.getAge());
	}

}
