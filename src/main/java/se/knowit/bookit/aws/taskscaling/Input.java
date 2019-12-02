package se.knowit.bookit.aws.taskscaling;

import java.util.Arrays;

public class Input {
    public String clusterName;
    public String[] serviceNames;
    public int desiredCount;

    @Override
    public String toString() {
        return "Input{" +
                "clusterName='" + clusterName + '\'' +
                ", serviceNames=" + Arrays.toString(serviceNames) +
                ", desiredCount=" + desiredCount +
                '}';
    }
}
