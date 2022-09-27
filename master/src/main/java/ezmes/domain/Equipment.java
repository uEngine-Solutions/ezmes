package ezmes.domain;

import ezmes.MasterApplication;
import ezmes.domain.EquipmentChanged;
import ezmes.domain.EquipmentRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Equipment_table")
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mchnNm;

    private String mchnCd;

    private String mchnSts;

    @PostPersist
    public void onPostPersist() {
        EquipmentRegistered equipmentRegistered = new EquipmentRegistered(this);
        equipmentRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        EquipmentChanged equipmentChanged = new EquipmentChanged(this);
        equipmentChanged.publishAfterCommit();
    }

    public static EquipmentRepository repository() {
        EquipmentRepository equipmentRepository = MasterApplication.applicationContext.getBean(
            EquipmentRepository.class
        );
        return equipmentRepository;
    }

    public static void 변경요청(
        EquipmentChangeRequested equipmentChangeRequested
    ) {
        /** Example 1:  new item 
        Equipment equipment = new Equipment();
        repository().save(equipment);

        */

        /** Example 2:  finding and process
        
        repository().findById(equipmentChangeRequested.get???()).ifPresent(equipment->{
            
            equipment // do something
            repository().save(equipment);


         });
        */

    }
}
