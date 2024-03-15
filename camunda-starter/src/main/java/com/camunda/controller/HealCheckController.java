package com.camunda.controller;

import com.camunda.constant.ApiConst;
import com.camunda.constant.Const;
import com.camunda.dto.HealCheckDTO;
import com.camunda.service.HealCheckService;
import io.camunda.zeebe.client.ZeebeClient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HealCheckController {

    @Autowired
    private HealCheckService healCheckService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(ApiConst.STATUS)
    public ResponseEntity<?> getStatusSystem() {
        return new ResponseEntity<>(healCheckService.getStatusSystem(), HttpStatus.OK);
    }

    @GetMapping(ApiConst.STATUS_DATABASE)
    public ResponseEntity<?> getStatusDatabase() {
        HealCheckDTO healCheckDTO = new HealCheckDTO();
        healCheckDTO.setService(Const.DATABASE);
        try {
            Query query = entityManager.createQuery("SELECT 1");
            if (query.getSingleResult() != null) {
                healCheckDTO.setStatus(Const.RUNNING);
            }
        } catch (Exception ex) {
            healCheckDTO.setStatus(ex.getMessage());
        }
        return new ResponseEntity<>(healCheckDTO, HttpStatus.OK);
    }

    @Autowired
    private ZeebeClient client;


    @GetMapping("/start")
    public ResponseEntity<?> start() {
        System.out.println("start...");
        Map<String, String> variables = new HashMap<>();
        variables.put(UUID.randomUUID().toString(), new Date().toString());
        client.newCreateInstanceCommand()
                .bpmnProcessId("SaleOpenDetailDocumentDSA")
                .latestVersion()
                .variables(variables)
                .send()
                .join();
        System.out.println("------ end.");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
