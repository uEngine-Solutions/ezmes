package ezmes.domain;

import ezmes.ProductApplication;
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

    private String coptrPrdtCd;

    private String coptrItmNo;

    private String coptrItmNm;

    private String coptrItmStd;

    private String coptrWrhsCnt;

    private String coptrCd;

    private Production production;

    public static MaterialsRepository repository() {
        MaterialsRepository materialsRepository = ProductApplication.applicationContext.getBean(
            MaterialsRepository.class
        );
        return materialsRepository;
    }

    public static void 원자재변경(RawMaterialRegistered rawMaterialRegistered) {
        /** Example 1:  new item 
        Materials materials = new Materials();
        repository().save(materials);

        */

        /** Example 2:  finding and process
        
        repository().findById(rawMaterialRegistered.get???()).ifPresent(materials->{
            
            materials // do something
            repository().save(materials);


         });
        */

    }

    public static void 원자재변경(RawMaterialChanged rawMaterialChanged) {
        /** Example 1:  new item 
        Materials materials = new Materials();
        repository().save(materials);

        */

        /** Example 2:  finding and process
        
        repository().findById(rawMaterialChanged.get???()).ifPresent(materials->{
            
            materials // do something
            repository().save(materials);


         });
        */

    }

    public static void 원자재변경(RawMaterialsCanceled rawMaterialsCanceled) {
        /** Example 1:  new item 
        Materials materials = new Materials();
        repository().save(materials);

        */

        /** Example 2:  finding and process
        
        repository().findById(rawMaterialsCanceled.get???()).ifPresent(materials->{
            
            materials // do something
            repository().save(materials);


         });
        */

    }
}
