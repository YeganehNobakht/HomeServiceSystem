package ir.maktab.data.repository.buildingFacilities;

import ir.maktab.data.entity.BuildingFacilities.BuildingFacilities;
import ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities;
import ir.maktab.data.entity.moving.Moving;
import ir.maktab.data.entity.moving.SubMoving;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubBuildingFacilitiesInitializer {
    private final SubBuildingFacilitiesRepository subVehicleRepository;
    private final BuildingFacilitiesRepository buildingFacilitiesRepository;

    public SubBuildingFacilitiesInitializer(SubBuildingFacilitiesRepository subBuildingFacilitiesRepository,
                                            BuildingFacilitiesRepository buildingFacilitiesRepository) {
        this.subVehicleRepository = subBuildingFacilitiesRepository;
        this.buildingFacilitiesRepository = buildingFacilitiesRepository;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/buildingFacilities.properties"));
            //add data if database is empty.
            if (subVehicleRepository.getAll().isEmpty()){
                for (Object key : prop.keySet()) {
                    String[] split = prop.get(key).toString().split(",");
                    SubBuildingFacilities subBuildingFacilities = new SubBuildingFacilities(key.toString(), Double.valueOf(split[0]), split[1]);
                    BuildingFacilities buildingFacilities = new BuildingFacilities();
                    buildingFacilities.getSubBuildingFacilitiesList().add(subBuildingFacilities);
                    buildingFacilitiesRepository.create(buildingFacilities);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
