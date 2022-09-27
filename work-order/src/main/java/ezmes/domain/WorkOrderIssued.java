package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WorkOrderIssued extends AbstractEvent {

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

    public WorkOrderIssued(WorkOrder aggregate) {
        super(aggregate);
    }

    public WorkOrderIssued() {
        super();
    }
    // keep

}
