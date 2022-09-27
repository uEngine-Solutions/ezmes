package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class WorkOrderChanged extends AbstractEvent {

    private Long id;

    public WorkOrderChanged(WorkOrder aggregate) {
        super(aggregate);
    }

    public WorkOrderChanged() {
        super();
    }
    // keep

}
