package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WorkerRegistered extends AbstractEvent {

    private Long id;
    private String userNm;
    private String userId;
    private String userPswd;
    private String userHpNo;
    private String userEml;
    private String userSts;
    // keep

}
