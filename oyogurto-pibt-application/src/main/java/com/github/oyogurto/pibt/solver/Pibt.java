package com.github.oyogurto.pibt.solver;

import com.github.oyogurto.pibt.model.MapfInstance;

/**
 * @author Jingchun.Zhou
 * @since 6/21/2022
 */
public class Pibt extends AbstractMapfSolver {
    public static final String NAME = "PIBT";
    public Pibt(MapfInstance p) {
        super(p);
    }

    @Override
    public String getSolverName() {
        return NAME;
    }
}
