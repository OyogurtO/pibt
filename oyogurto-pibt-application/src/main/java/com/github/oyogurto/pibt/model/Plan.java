package com.github.oyogurto.pibt.model;

import com.github.oyogurto.pibt.graph.Node;
import com.github.oyogurto.pibt.graph.Path;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
public class Plan {
    List<List<Node>> configs;

    public List<Node> get(int t) {
        return configs.get(t);
    }
    public Node get(int t, int i) {
        return configs.get(t).get(i);
    }
    public Path getPath(int i) {
        List<Node> nodes = new ArrayList<>();
        int makeSpan = getMakeSpan();
        for (int t = 0; t <= makeSpan; t++) {
            nodes.add(get(t, i));
        }
        return new Path(nodes);
    }

    public List<Node> last() {
        return configs.get(getMakeSpan());
    }

    public Node last(int i) {
        return configs.get(getMakeSpan()).get(i);
    }

    public void clear() {
        configs.clear();
    }

    public void add(List<Node> config) {
        configs.add(config);
    }

    public int getMakeSpan() {
        return configs.size()-1;
    }

    public boolean validate(MapfInstance p) {
        // TODO:
        return false;
    }
}
