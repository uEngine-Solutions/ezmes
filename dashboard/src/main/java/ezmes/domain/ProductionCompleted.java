package ezmes.domain;

import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class ProductionCompleted extends AbstractEvent {

    private Long id;
    private Date JOB_DT;
    private String USER_ID;
    private Long EQMT_ID;
    private String ITM_NO;
    private String ITM_NM;
    private String ITM_STD;
    private String ITM_CNT;
    private String PRDT_CD;
    private Long orderId;
}
