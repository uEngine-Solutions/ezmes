package ezmes.domain;

import ezmes.ProductApplication;
import ezmes.domain.EquipmentChangeRequested;
import ezmes.domain.ProductionStatusCanceled;
import ezmes.domain.ProductionStatusChanged;
import ezmes.domain.ProductionStatusRegistered;
import ezmes.domain.WorkerChangeRequested;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Production_table")
@Data
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date jobDt;

    private String userId;

    private Long eqmtId;

    private String itmNo;

    private String itmNm;

    private String itmStd;

    private Long itmCnt;

    private String prdtCd;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {
        ProductionStatusRegistered productionStatusRegistered = new ProductionStatusRegistered(
            this
        );
        productionStatusRegistered.publishAfterCommit();

        ProductionStatusCanceled productionStatusCanceled = new ProductionStatusCanceled(
            this
        );
        productionStatusCanceled.publishAfterCommit();

        ProductionStatusChanged productionStatusChanged = new ProductionStatusChanged(
            this
        );
        productionStatusChanged.publishAfterCommit();

        WorkerChangeRequested workerChangeRequested = new WorkerChangeRequested(
            this
        );
        workerChangeRequested.publishAfterCommit();

        EquipmentChangeRequested equipmentChangeRequested = new EquipmentChangeRequested(
            this
        );
        equipmentChangeRequested.publishAfterCommit();
    }

    public static ProductionRepository repository() {
        ProductionRepository productionRepository = ProductApplication.applicationContext.getBean(
            ProductionRepository.class
        );
        return productionRepository;
    }

    public void complete(CompleteCommand completeCommand) {

        setItmCnt(completeCommand.getItemCount());

        ProductionCompleted productionCompleted = new ProductionCompleted(this);


        productionCompleted.publishAfterCommit();
    }

    public static void 작업변경(WorkOrderChanged workOrderChanged) {
        /** Example 1:  new item 
        Production production = new Production();
        repository().save(production);

        */

        /** Example 2:  finding and process
        
        repository().findById(workOrderChanged.get???()).ifPresent(production->{
            
            production // do something
            repository().save(production);


         });
        */

    }

    public static void 작업취소(WorkOrderCanceled workOrderCanceled) {
        /** Example 1:  new item 
        Production production = new Production();
        repository().save(production);

        */

        /** Example 2:  finding and process
        
        repository().findById(workOrderCanceled.get???()).ifPresent(production->{
            
            production // do something
            repository().save(production);


         });
        */

    }
}
