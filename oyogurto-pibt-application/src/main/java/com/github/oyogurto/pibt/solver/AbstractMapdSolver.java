package com.github.oyogurto.pibt.solver;

import com.github.oyogurto.pibt.graph.Node;
import com.github.oyogurto.pibt.model.MapdInstance;
import com.github.oyogurto.pibt.model.Task;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/21/2022
 */
public abstract class AbstractMapdSolver extends AbstractSolver<MapdInstance> {
    List<List<Node>> hist_targets;  // time, agent -> current target
    List<List<Task>> hist_tasks;    // time, agent -> assigned_task
    boolean use_distance_table;
    int preprocessing_comp_time;                          // computation time
    // [node_id][node_id]
    int[][] distance_table;

    public AbstractMapdSolver(MapdInstance p) {
        super(p);
    }

    @Override
    void exec() {

    }

    abstract void run();
}
