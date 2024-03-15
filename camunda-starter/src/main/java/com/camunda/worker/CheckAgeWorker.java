package com.camunda.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CheckAgeWorker {

    @JobWorker(type = "foo")
    public Map<String, String> checkAge(final JobClient client, final ActivatedJob job) {
        System.out.println("----------- CHECK age 1------------");
        System.out.println("---------- checkAge1 job " + job);
        System.out.println("---------- variables: " + job.getVariables());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status", "ok");
        return hashMap;
    }

    @JobWorker(type = "age2", fetchVariables = {"status", "variable1"})
    public Map<String, String> checkAge2(final JobClient client, final ActivatedJob job,
                                         @Variable(name = "status") String status) {
        System.out.println("----------- CHECK age 2");
        System.out.println("status: " + status);
        System.out.println("---------- variables: " + job.getVariables());
        System.out.println("---------- checkAge2 job " + job);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("statusOther", "ok");
        return hashMap;
    }

//    @JobWorker(type = "dup")
//    public Map<String, String> checkDup(final ActivatedJob job) {
//        System.out.println("---------- checkDup " + job);
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("status", "ok");
//        return hashMap;
//    }
//
}
