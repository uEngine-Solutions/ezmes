package ezmes.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ezmes.config.kafka.KafkaProcessor;
import ezmes.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProductionRepository productionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkOrderIssued'"
    )
    public void wheneverWorkOrderIssued_작업요청(
        @Payload WorkOrderIssued workOrderIssued
    ) {
        WorkOrderIssued event = workOrderIssued;
        System.out.println(
            "\n\n##### listener 작업요청 : " + workOrderIssued + "\n\n"
        );

        // Sample Logic //
        Production.작업요청(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkOrderChanged'"
    )
    public void wheneverWorkOrderChanged_작업변경(
        @Payload WorkOrderChanged workOrderChanged
    ) {
        WorkOrderChanged event = workOrderChanged;
        System.out.println(
            "\n\n##### listener 작업변경 : " + workOrderChanged + "\n\n"
        );

        // Sample Logic //
        Production.작업변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkOrderCanceled'"
    )
    public void wheneverWorkOrderCanceled_작업취소(
        @Payload WorkOrderCanceled workOrderCanceled
    ) {
        WorkOrderCanceled event = workOrderCanceled;
        System.out.println(
            "\n\n##### listener 작업취소 : " + workOrderCanceled + "\n\n"
        );

        // Sample Logic //
        Production.작업취소(event);
    }
    // keep

}
