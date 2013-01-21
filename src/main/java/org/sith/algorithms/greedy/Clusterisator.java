package org.sith.algorithms.greedy;

import org.sith.algorithms.common.clustering.Cluster;
import org.sith.algorithms.common.clustering.DataPoint;
import org.sith.algorithms.quickunion.FindUnion;
import org.sith.algorithms.quickunion.WeightedWithPathCompressedQuickUnion;

import java.util.*;

/**
 * Date: 12/19/12
 * Time: 8:02 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Clusterisator {


    private List<Distance> edges = new ArrayList<>();

    private FindUnion findUnion;

    public Clusterisator(int n) {
        findUnion = new WeightedWithPathCompressedQuickUnion(n + 1);
    }


    public void addDataPoint(DataPoint dataPoint) {
        Cluster cluster = new Cluster();
        cluster.getDataPoints().add(dataPoint);
    }


    public void addDistance(DataPoint from, DataPoint to, double distance) {
        edges.add(new Distance(from, to, distance));


    }


    public double process(int k) {


        Collections.sort(edges);


        for (int i = 0; i < edges.size(); i++) {
            Distance distance = edges.get(i);
            int from = distance.from.getLabel();
            int to = distance.to.getLabel();

            if (findUnion.find(from, to)) {
                continue;
            }
            findUnion.union(from, to);
            if (findUnion.getGroups() == k + 1) {
                break;
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            Distance distance = edges.get(i);

            if (!findUnion.find(distance.from.getLabel(), distance.to.getLabel())) {
                return distance.distance;

            }

        }

        return 0;
    }


    public int getClusterNumber(int length) {
        int count=0;
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++) {
            Distance distance = edges.get(i);
            if (distance.distance == length) {
                return count;
            }
            int from = distance.from.getLabel();
            int to = distance.to.getLabel();

            if (findUnion.find(from, to)) {
                continue;
            }
            findUnion.union(from, to);
            count++;

        }

        return count;


    }



    class Distance implements Comparable<Distance> {
        DataPoint from, to;
        double distance;

        Distance(DataPoint from, DataPoint to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Distance{" +
                    "from=" + from +
                    ", to=" + to +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Distance distance = (Distance) o;

            if (from != null ? !from.equals(distance.from) : distance.from != null) return false;
            if (to != null ? !to.equals(distance.to) : distance.to != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = from != null ? from.hashCode() : 0;
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Distance o) {
            int distanceDiff = Double.compare(distance, o.distance);
            if (distanceDiff != 0) {
                return distanceDiff;
            }

            int fromDiff = from.getLabel() - o.from.getLabel();

            if (fromDiff != 0) {
                return fromDiff;
            }
            return to.getLabel() - o.to.getLabel();
        }
    }


}
