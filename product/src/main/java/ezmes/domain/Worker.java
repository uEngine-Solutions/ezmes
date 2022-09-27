package ezmes.domain;

import ezmes.ProductApplication;
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

    private String userId;

    private String userPswd;

    private String userHpNo;

    private String userEml;

    private String userSts;

    @Embedded
    private ProductionId productionId;

    public static WorkerRepository repository() {
        WorkerRepository workerRepository = ProductApplication.applicationContext.getBean(
            WorkerRepository.class
        );
        return workerRepository;
    }

    public static void 작업자변경(WorkerRegistered workerRegistered) {
        /** Example 1:  new item 
        Worker worker = new Worker();
        repository().save(worker);

        */

        /** Example 2:  finding and process
        
        repository().findById(workerRegistered.get???()).ifPresent(worker->{
            
            worker // do something
            repository().save(worker);


         });
        */

    }

    public static void 작업자변경(WorkerChanged workerChanged) {
        /** Example 1:  new item 
        Worker worker = new Worker();
        repository().save(worker);

        */

        /** Example 2:  finding and process
        
        repository().findById(workerChanged.get???()).ifPresent(worker->{
            
            worker // do something
            repository().save(worker);


         });
        */

    }

    public static void 작업자변경(WorkerCanceled workerCanceled) {
        /** Example 1:  new item 
        Worker worker = new Worker();
        repository().save(worker);

        */

        /** Example 2:  finding and process
        
        repository().findById(workerCanceled.get???()).ifPresent(worker->{
            
            worker // do something
            repository().save(worker);


         });
        */

    }
}
