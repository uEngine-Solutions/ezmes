package ezmes.domain;

import ezmes.MasterApplication;
import ezmes.domain.RawMaterialChanged;
import ezmes.domain.RawMaterialRegistered;
import ezmes.domain.RawMaterialsCanceled;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Materials_table")
@Data
public class Materials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prdtCd;

    private String itmNo;

    private String itmNm;

    private String itmStd;

    private String wrhsCnt;

    private String coptrCd;

    @PostPersist
    public void onPostPersist() {
        RawMaterialRegistered rawMaterialRegistered = new RawMaterialRegistered(
            this
        );
        rawMaterialRegistered.publishAfterCommit();

        RawMaterialChanged rawMaterialChanged = new RawMaterialChanged(this);
        rawMaterialChanged.publishAfterCommit();

        RawMaterialsCanceled rawMaterialsCanceled = new RawMaterialsCanceled(
            this
        );
        rawMaterialsCanceled.publishAfterCommit();
    }

    public static MaterialsRepository repository() {
        MaterialsRepository materialsRepository = MasterApplication.applicationContext.getBean(
            MaterialsRepository.class
        );
        return materialsRepository;
    }
}
