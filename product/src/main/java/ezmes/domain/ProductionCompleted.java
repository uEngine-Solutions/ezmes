package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ProductionCompleted extends AbstractEvent {

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

    public ProductionCompleted(Production aggregate) {
        super(aggregate);
    }

    public ProductionCompleted() {
        super();
    }
    // keep

}
