package se.knowit.bookit.aws.taskscaling;

import com.amazonaws.services.ecs.*;
import com.amazonaws.services.ecs.model.UpdateServiceRequest;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.Arrays;

public class FargateTaskScaler {

    public void handleRequest(Input input, Context context) {
        final AmazonECS ecsClient = AmazonECSClientBuilder.defaultClient();
        try {
            Arrays.stream(input.serviceNames).forEach((service) -> ecsClient.updateService(
                    new UpdateServiceRequest()
                            .withCluster(input.clusterName)
                            .withService(service)
                            .withDesiredCount(input.desiredCount)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
