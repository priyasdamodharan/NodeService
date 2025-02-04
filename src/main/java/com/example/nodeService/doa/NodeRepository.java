package com.example.nodeService.doa;

import com.example.nodeService.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, String> {

    // Custom query to get the last nodeId
    @Query("SELECT n.nodeId FROM Node n ORDER BY n.nodeId DESC LIMIT 1")
    String findLastNodeId();

    // Custom query to check if a Node with the same values already exists
    @Query("SELECT COUNT(n) > 0 FROM Node n WHERE n.nodeType = :nodeType AND n.parentNodeGroupName = :parentNodeGroupName " +
            "AND n.parentNodeGroupId = :parentNodeGroupId AND n.parentNode = :parentNode AND n.description = :description " +
            "AND n.memo = :memo")
    boolean existsByNodeDetails(
            @Param("nodeType") String nodeType,
            @Param("parentNodeGroupName") String parentNodeGroupName,
            @Param("parentNodeGroupId") String parentNodeGroupId,
            @Param("parentNode") String parentNode,
            @Param("description") String description,
            @Param("memo") String memo);

    Node findByNodeId(String nodeId);  // Custom query to find a node by nodeId
}
