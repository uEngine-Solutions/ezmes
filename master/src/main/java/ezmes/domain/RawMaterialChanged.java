package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RawMaterialChanged extends AbstractEvent {

    private Long id;
    private String prdtCd;
    private String itmNo;
    private String itmNm;
    private String itmStd;
    private String wrhsCnt;
    private String coptrCd;

    public RawMaterialChanged(Materials aggregate) {
        super(aggregate);
    }

    public RawMaterialChanged() {
        super();
    }
    // keep

}
