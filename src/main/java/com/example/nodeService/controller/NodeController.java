package com.example.nodeService.controller;

import com.example.nodeService.model.Node;
import com.example.nodeService.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Nodes/")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping("addNodes")
    public ResponseEntity<String> addNode(@RequestBody Node node) {
        return nodeService.addNode(node);
    }

    @GetMapping("getAllNodes")
    public ResponseEntity<List<Node>> getNodes() {
        return nodeService.getAllNodes();
    }
}
