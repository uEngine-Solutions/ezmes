package ezmes.domain;

import ezmes.ProductApplication;
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

    @Embedded
    private ProductionId productionId;

    public static EquipmentRepository repository() {
        EquipmentRepository equipmentRepository = ProductApplication.applicationContext.getBean(
            EquipmentRepository.class
        );
        return equipmentRepository;
    }

    public static void 설비변경(EquipmentRegistered equipmentRegistered) {
        /** Example 1:  new item 
        Equipment equipment = new Equipment();
        repository().save(equipment);

        */

        /** Example 2:  finding and process
        
        repository().findById(equipmentRegistered.get???()).ifPresent(equipment->{
            
            equipment // do something
            repository().save(equipment);


         });
        */

    }

    public static void 설비변경(EquipmentChanged equipmentChanged) {
        /** Example 1:  new item 
        Equipment equipment = new Equipment();
        repository().save(equipment);

        */

        /** Example 2:  finding and process
        
        repository().findById(equipmentChanged.get???()).ifPresent(equipment->{
            
            equipment // do something
            repository().save(equipment);


         });
        */

    }

    public static void 설비변경(FacilityCanceled facilityCanceled) {
        /** Example 1:  new item 
        Equipment equipment = new Equipment();
        repository().save(equipment);

        */

        /** Example 2:  finding and process
        
        repository().findById(facilityCanceled.get???()).ifPresent(equipment->{
            
            equipment // do something
            repository().save(equipment);


         });
        */

    }
}
