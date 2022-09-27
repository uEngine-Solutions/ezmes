package ezmes.domain;

import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class WorkOrderIssued extends AbstractEvent {

    private Long id;
    private Long EQMT_ID;
    private String PRCS_ID;
    private String PRCS_SQN;
    private String PRCS_NM;
    private String PRDT_CD;
    private Date REG_DT;
    private String REG_NM;
    private String ITM_NO;
    private String ITM_NM;
    private String ITM_STD;
    private String ORDR_AMNT;
    private Date ORDR_DT;
    private Date ORDR_YMD;
    private Date DLVR_DT;
}
