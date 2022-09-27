package ezmes.domain;

import ezmes.WorkOrderApplication;
import ezmes.domain.WorkOrderCanceled;
import ezmes.domain.WorkOrderChanged;
import ezmes.domain.WorkOrderIssued;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "WorkOrder_table")
@Data
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long eqmtId;

    private String prcsId;

    private String prcsSqn;

    private String prcsNm;

    private String prdtCd;

    private Date regDt;

    private String regNm;

    private String itmNo;

    private String itmNm;

    private String itmStd;

    private String ordrAmnt;

    private Date ordrDt;

    private Date ordrYmd;

    private Date dlvrDt;

    @PostPersist
    public void onPostPersist() {
        WorkOrderIssued workOrderIssued = new WorkOrderIssued(this);
        workOrderIssued.publishAfterCommit();

        WorkOrderChanged workOrderChanged = new WorkOrderChanged(this);
        workOrderChanged.publishAfterCommit();

        WorkOrderCanceled workOrderCanceled = new WorkOrderCanceled(this);
        workOrderCanceled.publishAfterCommit();
    }

    public static WorkOrderRepository repository() {
        WorkOrderRepository workOrderRepository = WorkOrderApplication.applicationContext.getBean(
            WorkOrderRepository.class
        );
        return workOrderRepository;
    }
}
