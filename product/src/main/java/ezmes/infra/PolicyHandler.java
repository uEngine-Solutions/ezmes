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

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    MaterialsRepository materialsRepository;

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

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EquipmentRegistered'"
    )
    public void wheneverEquipmentRegistered_설비변경(
        @Payload EquipmentRegistered equipmentRegistered
    ) {
        EquipmentRegistered event = equipmentRegistered;
        System.out.println(
            "\n\n##### listener 설비변경 : " + equipmentRegistered + "\n\n"
        );

        // Sample Logic //
        Equipment.설비변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EquipmentChanged'"
    )
    public void wheneverEquipmentChanged_설비변경(
        @Payload EquipmentChanged equipmentChanged
    ) {
        EquipmentChanged event = equipmentChanged;
        System.out.println(
            "\n\n##### listener 설비변경 : " + equipmentChanged + "\n\n"
        );

        // Sample Logic //
        Equipment.설비변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FacilityCanceled'"
    )
    public void wheneverFacilityCanceled_설비변경(
        @Payload FacilityCanceled facilityCanceled
    ) {
        FacilityCanceled event = facilityCanceled;
        System.out.println(
            "\n\n##### listener 설비변경 : " + facilityCanceled + "\n\n"
        );

        // Sample Logic //
        Equipment.설비변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkerRegistered'"
    )
    public void wheneverWorkerRegistered_작업자변경(
        @Payload WorkerRegistered workerRegistered
    ) {
        WorkerRegistered event = workerRegistered;
        System.out.println(
            "\n\n##### listener 작업자변경 : " + workerRegistered + "\n\n"
        );

        // Sample Logic //
        Worker.작업자변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkerChanged'"
    )
    public void wheneverWorkerChanged_작업자변경(
        @Payload WorkerChanged workerChanged
    ) {
        WorkerChanged event = workerChanged;
        System.out.println(
            "\n\n##### listener 작업자변경 : " + workerChanged + "\n\n"
        );

        // Sample Logic //
        Worker.작업자변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WorkerCanceled'"
    )
    public void wheneverWorkerCanceled_작업자변경(
        @Payload WorkerCanceled workerCanceled
    ) {
        WorkerCanceled event = workerCanceled;
        System.out.println(
            "\n\n##### listener 작업자변경 : " + workerCanceled + "\n\n"
        );

        // Sample Logic //
        Worker.작업자변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RawMaterialRegistered'"
    )
    public void wheneverRawMaterialRegistered_원자재변경(
        @Payload RawMaterialRegistered rawMaterialRegistered
    ) {
        RawMaterialRegistered event = rawMaterialRegistered;
        System.out.println(
            "\n\n##### listener 원자재변경 : " + rawMaterialRegistered + "\n\n"
        );

        // Sample Logic //
        Materials.원자재변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RawMaterialChanged'"
    )
    public void wheneverRawMaterialChanged_원자재변경(
        @Payload RawMaterialChanged rawMaterialChanged
    ) {
        RawMaterialChanged event = rawMaterialChanged;
        System.out.println(
            "\n\n##### listener 원자재변경 : " + rawMaterialChanged + "\n\n"
        );

        // Sample Logic //
        Materials.원자재변경(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RawMaterialsCanceled'"
    )
    public void wheneverRawMaterialsCanceled_원자재변경(
        @Payload RawMaterialsCanceled rawMaterialsCanceled
    ) {
        RawMaterialsCanceled event = rawMaterialsCanceled;
        System.out.println(
            "\n\n##### listener 원자재변경 : " + rawMaterialsCanceled + "\n\n"
        );

        // Sample Logic //
        Materials.원자재변경(event);
    }
    // keep

}
