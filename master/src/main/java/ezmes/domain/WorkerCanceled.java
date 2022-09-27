package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WorkerCanceled extends AbstractEvent {

    private Long id;
    private String userNm;
    private String userId;
    private String userPswd;
    private String userHpNo;
    private String userEml;
    private String userSts;

    public WorkerCanceled(Worker aggregate) {
        super(aggregate);
    }

    public WorkerCanceled() {
        super();
    }
    // keep

}
