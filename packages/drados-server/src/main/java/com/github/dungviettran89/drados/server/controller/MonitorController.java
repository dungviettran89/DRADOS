package com.github.dungviettran89.drados.server.controller;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/monitor")
@Slf4j
public class MonitorController {

    @Autowired
    private DockerClient dockerClient;

    @GetMapping("container")
    @Operation(description = "Get all running containers")
    List<Container> container() {
        log.info("GET /api/monitor/container");
        return dockerClient.listContainersCmd().exec();
    }
}
