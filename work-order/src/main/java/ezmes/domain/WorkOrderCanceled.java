package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WorkOrderCanceled extends AbstractEvent {

    private Long id;

    public WorkOrderCanceled(WorkOrder aggregate) {
        super(aggregate);
    }

    public WorkOrderCanceled() {
        super();
    }
    // keep

}
