package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RawMaterialRegistered extends AbstractEvent {

    private Long id;
    private String prdtCd;
    private String itmNo;
    private String itmNm;
    private String itmStd;
    private String wrhsCnt;
    private String coptrCd;
    // keep

}
