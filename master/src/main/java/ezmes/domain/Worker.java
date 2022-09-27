package ezmes.domain;

import ezmes.MasterApplication;
import ezmes.domain.WorkerCanceled;
import ezmes.domain.WorkerChanged;
import ezmes.domain.WorkerRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Worker_table")
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userNm;

    private String userPswd;

    private String userHpNo;

    private String userEml;

    private String userSts;

    @PostPersist
    public void onPostPersist() {
        WorkerRegistered workerRegistered = new WorkerRegistered(this);
        workerRegistered.publishAfterCommit();

        WorkerChanged workerChanged = new WorkerChanged(this);
        workerChanged.publishAfterCommit();

        WorkerCanceled workerCanceled = new WorkerCanceled(this);
        workerCanceled.publishAfterCommit();
    }

    public static WorkerRepository repository() {
        WorkerRepository workerRepository = MasterApplication.applicationContext.getBean(
            WorkerRepository.class
        );
        return workerRepository;
    }

    public void 설비취소() {
        FacilityCanceled facilityCanceled = new FacilityCanceled(this);
        facilityCanceled.publishAfterCommit();
    }

    public static void 변경요청(WorkerChangeRequested workerChangeRequested) {
        /** Example 1:  new item 
        Worker worker = new Worker();
        repository().save(worker);

        */

        /** Example 2:  finding and process
        
        repository().findById(workerChangeRequested.get???()).ifPresent(worker->{
            
            worker // do something
            repository().save(worker);


         });
        */

    }
}
