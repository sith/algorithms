package org.sith.algorithms.common.outputs;

import org.sith.algorithms.common.outputs.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11/22/12
 * Time: 8:08 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class GraphPaths implements Output {

    private List<Path> paths = new ArrayList<>();


    public void addPath(Path path) {
        paths.add(path);
    }


    public List<Path> getPaths() {
        return paths;
    }

    public static class Path {
        private final int[] vertex;


        public Path(int[] vertex) {
            this.vertex = vertex;
        }

        public int[] getVertex() {
            return vertex;
        }
    }


}
