package com.github.oyogurto.pibt.model;

import com.github.oyogurto.pibt.graph.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MapdInstance extends AbstractProblem {
    float taskFrequency;
    int taskNum;

    int currentTimestep;  // current timestep
    List<Task> TASKS_OPEN;
    List<Task> TASKS_CLOSED;

    List<Node> LOCS_PICKUP;             // candidates of pickup locations
    List<Node> LOCS_DELIVERY;           // candidates of delivery locations
    List<Node> LOCS_NONTASK_ENDPOINTS;  // endpoints, not necessary for PIBT
    List<Node> LOCS_ENDPOINTS;          // pickup, delivery, nontasks

    boolean specifyPickupDelivLocs;
}
