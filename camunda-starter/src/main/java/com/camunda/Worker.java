package com.camunda;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Worker {

    @JobWorker(type = "foo")
    public Map<String, String> checkAge(JobClient client, ActivatedJob job) {
        System.out.println("----------- CHECK age 1------------");
        System.out.println("---------- checkAge1 job " + job);
        System.out.println("---------- variables: " + job.getVariables());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status", "ok");
        return hashMap;
    }

}
