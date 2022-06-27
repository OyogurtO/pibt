package com.github.oyogurto.pibt.model;

import com.github.oyogurto.pibt.graph.Graph;
import com.github.oyogurto.pibt.graph.Node;
import lombok.Data;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
public abstract class AbstractProblem {
    /**
     * instance name
     */
    String instance;
    /**
     * graph
     */
    Graph graph;
//    std::mt19937* MT;
    /**
     * initial configuration
     */
    List<Node> configS;
    /**
     * goal configuration
     */
    List<Node> configG;
    /**
     * number of agents
     */
    int numAgents;
    /**
     * timestep limit
     */
    int maxTimestep;
    /**
     * comp_time limit, ms
     */
    int maxCompTime;

    public AbstractProblem() {
    }

    public AbstractProblem(String instance) {
        this.instance = instance;
    }

    public Node getStart(int i) {
        return configS.get(i);
    }
    public Node getGoal(int i) {
        return configG.get(i);
    }
}
