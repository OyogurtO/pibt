package com.github.oyogurto.pibt.solver;

import com.github.oyogurto.pibt.graph.Graph;
import com.github.oyogurto.pibt.model.AbstractProblem;
import com.github.oyogurto.pibt.model.Plan;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
public abstract class AbstractSolver<T extends AbstractProblem> {
    T problem;
    Graph graph;           // graph
    int maxTimestep;   // maximum makespan
    int maxCompTime;  // time limit for computation, ms

    @Getter
    Plan solution;            // solution
    boolean solved = false;              // success -> true, failed -> false (default)


    long compTime = 0;             // computation time
    long tStart;  // when to start solving

    @Setter
    boolean verbose = false;    // true -> print additional info
    @Setter
    boolean logShort = false;  // true -> cannot visualize the result, default: false

    public AbstractSolver(T p) {
        this.problem = p;
        this.graph = p.getGraph();
        this.maxTimestep = p.getMaxTimestep();
        this.maxCompTime = p.getMaxCompTime();
    }

    public void solve() {
        start();
        exec();
        end();
    }
    public void start() {
        tStart = System.currentTimeMillis();
    }

    abstract void exec();

    public void end() {
        compTime = getSolverElapsedTime();
    }
    public long getSolverElapsedTime() {
        return System.currentTimeMillis() - tStart;
    }

    public abstract String getSolverName();

    public boolean succeed() {
        return solved;
    }

}
