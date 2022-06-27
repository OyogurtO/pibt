package com.github.oyogurto.pibt.model;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
public class MapfInstance extends AbstractProblem {
    private boolean instanceInitialized;
    public MapfInstance(String instance) {
        super(instance);
        instanceInitialized = true;
    }
    public void makeScenFile(String outputFile) {
        //TODO:
    }
}
