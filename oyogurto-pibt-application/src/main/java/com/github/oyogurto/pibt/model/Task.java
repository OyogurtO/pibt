package com.github.oyogurto.pibt.model;

import com.github.oyogurto.pibt.graph.Node;
import lombok.Data;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
public class Task {
    public static int TASK_ID_CNT = 0;
    public static final int NULL = -1;

    int id;
    Node locPickup;
    Node locDelivery;
    Node locCurrent;
    int timestepAppear;
    int timestepFinished;
    boolean assigned;

    public Task(Node locPickup, Node locDelivery, int timestepAppear) {
        this.id = TASK_ID_CNT++;
        this.locPickup = locPickup;
        this.locDelivery = locDelivery;
        this.locCurrent = locPickup;
        this.timestepAppear = timestepAppear;
        this.timestepFinished = -1;
        this.assigned = false;
    }
}
