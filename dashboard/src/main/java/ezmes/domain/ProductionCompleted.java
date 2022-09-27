package ezmes.domain;

import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class ProductionCompleted extends AbstractEvent {

    private Long id;
    private Date jobDt;
    private String userId;
    private Long eqmtId;
    private String itmNo;
    private String itmNm;
    private String itmStd;
    private String itmCnt;
    private String prdtCd;
    private Long orderId;
}
