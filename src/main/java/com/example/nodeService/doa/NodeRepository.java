package com.example.nodeService.doa;

import com.example.nodeService.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, String> {

    @Query("SELECT n.nodeId FROM Node n ORDER BY n.nodeId DESC LIMIT 1")
    String findLastNodeId(); // Custom query to get the last nodeId

}
