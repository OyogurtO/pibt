package com.github.oyogurto.pibt.solver;

import com.github.oyogurto.pibt.graph.Node;
import com.github.oyogurto.pibt.model.MapfInstance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
public abstract class AbstractMapfSolver extends AbstractSolver<MapfInstance> {
    // useful info
    int LB_soc = 0;       // lower bound of soc
    int LB_makespan = 0;  // lower bound of makespan

    // distance to goal
    int[][] distance_table;// distance table
    int preprocessing_comp_time;       // computation time



    public AbstractMapfSolver(MapfInstance p) {
        super(p);
    }

    @Override
    void exec() {
        if (distance_table==null) {
            createDistanceTable();
        }
    }

    void createDistanceTable() {
        if (distance_table == null) {
            distance_table = new int[problem.getNumAgents()][graph.getNodesSize()];
        }
        for (int i = 0; i < problem.getNumAgents(); ++i) {
            // breadth first search
            Queue<Node> OPEN = new LinkedList<>();
            Node n = problem.getGoal(i);
            OPEN.add(n);
            distance_table[i][n.getId()] = 0;
            while (!OPEN.isEmpty()) {
                n = OPEN.remove();
                int d_n = distance_table[i][n.getId()];
                for (var m : n.getNeighbor()) {
                    int d_m = distance_table[i][m.getId()];
                    if (d_n + 1 >= d_m) {
                        continue;
                    }
                    distance_table[i][m.getId()] = d_n + 1;
                    OPEN.add(m);
                }
            }
        }
    }
}
