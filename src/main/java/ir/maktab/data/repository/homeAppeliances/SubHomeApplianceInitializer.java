package ir.maktab.data.repository.homeAppeliances;

import ir.maktab.data.entity.homeAppliances.HomeAppliances;
import ir.maktab.data.entity.homeAppliances.SubHomeAppliances;
import ir.maktab.data.entity.moving.Moving;
import ir.maktab.data.entity.moving.SubMoving;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubHomeApplianceInitializer {
    private final SubHomeAppliancesRepository subVehicleRepository;
    private final HomeAppliancesRepository homeAppliancesRepository;

    public SubHomeApplianceInitializer(SubHomeAppliancesRepository subHomeAppliancesRepository,
                                       HomeAppliancesRepository homeAppliancesRepository) {
        this.subVehicleRepository = subHomeAppliancesRepository;
        this.homeAppliancesRepository = homeAppliancesRepository;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/"));
            //add data if database is empty.
            if (subVehicleRepository.getAll().isEmpty()){
                for (Object key : prop.keySet()) {
                    String[] split = prop.get(key).toString().split(",");
                    SubHomeAppliances subHomeAppliances = new SubHomeAppliances(key.toString(), Double.valueOf(split[0]), split[1]);
                    HomeAppliances homeAppliances = new HomeAppliances();
                    homeAppliances.getSubHomeAppliancesList().add(subHomeAppliances);
                    homeAppliancesRepository.create(homeAppliances);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
