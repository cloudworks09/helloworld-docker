package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDockerApplication.class, args);
	}
}

@RestController
class HelloDockerRestController {

	@Value("${MY_POD_NAME:default_value}")
	private String podName;

	public String getPodName() {
		return podName;
	}

	public void setPodName(String podName) {
		this.podName = podName;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Value("${MY_NODE_NAME:default_value}")
	private String nodeName;

	@RequestMapping("/hello/{name}")
	public String helloDocker(@PathVariable(value = "name") String name) {
		// String podName = System.getenv("MY_POD_NAME");
		// String nodeName = System.getenv("MY_NODE_NAME");
		// String response = "Hello " + name + " Response received on : " + new Date();
		String response2 = "You did it. Welcome to HelloWorld of " + getPodName() + " Response received on : "
				+ getNodeName();
		return response2;

	}
}
