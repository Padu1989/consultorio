package br.com.paulomoreira.consultorio.config.amazon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfiguration {
	
	private static final String ACCESS_KEY = "AKIAVUXGUDVXXOUHAIO3";
	private static final String SECRET_KEY = "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";
	private static final String REGION="us-east-1";
	
	@Bean
	public BasicAWSCredentials basicAwsCredentials() {
		return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		
	}
	@Bean
	public AmazonS3 amazonS3() {
		return AmazonS3ClientBuilder.standard().withRegion(REGION)
		.withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials())).build();
	}
	
}
