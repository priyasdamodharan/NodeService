package com.example.nodeService.service;

import com.example.nodeService.model.Node;
import com.example.nodeService.doa.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    private static final String SPECIAL_CHAR_REGEX = "[!@#$%^&*()]"; // Excludes these specific characters


    public ResponseEntity<List<Node>> getAllNodes() {
        try {
            return new ResponseEntity<>(nodeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addNode(Node node) {
        try {

            String errorMessage = validateData(node);
            if (errorMessage != null) {
                // If there is an error, return the message with a bad request
                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
            }

            // Auto-generate nodeId and nodeName if not provided
            if (node.getNodeId() == null || node.getNodeId().isEmpty()) {
                String lastNodeId = nodeRepository.findLastNodeId();
                String newNodeId = generateNextNodeId(lastNodeId);
                node.setNodeId(newNodeId);
            }

            if (node.getNodeName() == null || node.getNodeName().isEmpty()) {
                String lastNodeId = nodeRepository.findLastNodeId();
                String newNodeName = generateNextNodeName(lastNodeId);
                node.setNodeName(newNodeName);
            }

            // Save node
            nodeRepository.save(node);
            return new ResponseEntity<>("Node added successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateNextNodeId(String lastNodeId) {
            if (lastNodeId != null && lastNodeId.startsWith("T300_")) {
                int lastNumber = Integer.parseInt(lastNodeId.substring(5));
                int newNumber = lastNumber + 1;
                return "T300_" + String.format("%03d", newNumber); // Incremental format
            }
            return "T300_001"; // Default starting ID
        }

        private String generateNextNodeName(String lastNodeId) {
            if (lastNodeId != null && lastNodeId.startsWith("T300_")) {
                int lastNumber = Integer.parseInt(lastNodeId.substring(5));
                int newNumber = lastNumber + 1;
                return "Node " + newNumber; // Incremental Node name like "Node 1", "Node 2"
            }
            return "Node 1"; // Default starting Node Name
        }

    private String validateData(Node node) {
        // Validation message for each field (excluding nodeId and nodeName, as they're auto-generated)
        String[] fieldNames = {"Node Type", "Parent Node Group Name", "Parent Node Group ID",
                "Parent Node", "Description", "Memo"};
        String[] fieldValues = {
                node.getNodeType(), node.getParentNodeGroupName(), node.getParentNodeGroupId(),
                node.getParentNode(), node.getDescription(), node.getMemo()
        };

        // Iterate over fields and check each one
        for (int i = 0; i < fieldNames.length; i++) {
            String fieldName = fieldNames[i];
            String fieldValue = fieldValues[i];

            if (isNullOrEmpty(fieldValue)) {
                return fieldName + " cannot be null or empty.";
            }

            if (containsSpecialCharacters(fieldValue)) {
                return fieldName + " cannot contain special characters: !@#$%^&*()";
            }
        }

        return null; // All fields are valid
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean containsSpecialCharacters(String input) {
        return input != null && Pattern.compile(SPECIAL_CHAR_REGEX).matcher(input).find();
    }

}
