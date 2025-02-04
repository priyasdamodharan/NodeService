package com.example.nodeService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "nodes")
public class Node {

    @Id
    private String nodeId;

    private String nodeName;
    private String description;
    private String memo;
    private String nodeType;
    private String parentNodeGroupName;
    private String parentNodeGroupId;
    private String parentNode;

    // Getters and setters
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getParentNodeGroupName() {
        return parentNodeGroupName;
    }

    public void setParentNodeGroupName(String parentNodeGroupName) {
        this.parentNodeGroupName = parentNodeGroupName;
    }

    public String getParentNodeGroupId() {
        return parentNodeGroupId;
    }

    public void setParentNodeGroupId(String parentNodeGroupId) {
        this.parentNodeGroupId = parentNodeGroupId;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }
}
