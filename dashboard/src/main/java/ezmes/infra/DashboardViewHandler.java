package ezmes.infra;

import ezmes.config.kafka.KafkaProcessor;
import ezmes.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenWorkOrderIssued_then_CREATE_1(
        @Payload WorkOrderIssued workOrderIssued
    ) {
        try {
            if (!workOrderIssued.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setOrderId(workOrderIssued.getId());
            dashboard.setPlanAmount(
                Long.valueOf(workOrderIssued.getOrdrAmnt())
            );
            dashboard.setRemain(Long.valueOf(workOrderIssued.getOrdrAmnt()));
            dashboard.setProductionAmount(0L);
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductionCompleted_then_UPDATE_1(
        @Payload ProductionCompleted productionCompleted
    ) {
        try {
            if (!productionCompleted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                productionCompleted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setProductionAmount(
                    dashboard.getProductionAmount() +
                    Long.valueOf(productionCompleted.getItmCnt())
                );
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductionCompleted_then_UPDATE_2(
        @Payload ProductionCompleted productionCompleted
    ) {
        try {
            if (!productionCompleted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(
                productionCompleted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setRemain(
                    dashboard.getRemain() -
                    Long.valueOf(productionCompleted.getItmCnt())
                );
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
