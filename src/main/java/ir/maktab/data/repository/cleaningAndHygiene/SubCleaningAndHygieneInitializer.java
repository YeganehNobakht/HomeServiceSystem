package ir.maktab.data.repository.cleaningAndHygiene;

import ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene;
import ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene;
import ir.maktab.data.entity.moving.Moving;
import ir.maktab.data.entity.moving.SubMoving;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubCleaningAndHygieneInitializer {
    private final SubCleaningAndHygieneRepository subVehicleRepository;
    private final CleaningAndHygieneRepository cleaningAndHygieneRepository;

    public SubCleaningAndHygieneInitializer(SubCleaningAndHygieneRepository subCleaningAndHygieneRepository,
                                            CleaningAndHygieneRepository cleaningAndHygieneRepository) {
        this.subVehicleRepository = subCleaningAndHygieneRepository;
        this.cleaningAndHygieneRepository = cleaningAndHygieneRepository;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/CleaningAndHygiene.properties"));
            //add data if database is empty.
            if (subVehicleRepository.getAll().isEmpty()){
                for (Object key : prop.keySet()) {
                    String[] split = prop.get(key).toString().split(",");
                    SubCleaningAndHygiene subCleaningAndHygiene = new SubCleaningAndHygiene(key.toString(), Double.valueOf(split[0]), split[1]);
                    CleaningAndHygiene cleaningAndHygiene = new CleaningAndHygiene();
                    cleaningAndHygiene.getSubCleaningAndHygieneArrayList().add(subCleaningAndHygiene);
                    cleaningAndHygieneRepository.create(cleaningAndHygiene);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
