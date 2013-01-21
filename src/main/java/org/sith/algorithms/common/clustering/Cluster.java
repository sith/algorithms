package org.sith.algorithms.common.clustering;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 12/19/12
 * Time: 8:29 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Cluster {

    private Set<DataPoint> dataPoints = new HashSet<>();


    public Set<DataPoint> getDataPoints() {
        return dataPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cluster cluster = (Cluster) o;

        if (dataPoints != null ? !dataPoints.equals(cluster.dataPoints) : cluster.dataPoints != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return dataPoints != null ? dataPoints.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "dataPoints=" + dataPoints +
                '}';
    }
}
