package ir.maktab.data.repository.buildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubBuildingDecorationInitializer {
    private final SubBuildingDecorationRepository subBuildingDecorationRepository;
    private final BuildingDecorationRepository buildingDecorationRepository;

    public SubBuildingDecorationInitializer(SubBuildingDecorationRepository subBuildingDecorationRepository,
                                            BuildingDecorationRepository buildingDecorationRepository) {
        this.subBuildingDecorationRepository = subBuildingDecorationRepository;
        this.buildingDecorationRepository = buildingDecorationRepository;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/buildingDecoration.properties"));
            //add data if database is empty.
            if (subBuildingDecorationRepository.getAll().isEmpty()){
                for (Object key : prop.keySet()) {
                    String[] split = prop.get(key).toString().split(",");
                    SubBuildingDecoration subBuildingDecoration1 = new SubBuildingDecoration(key.toString(), Double.valueOf(split[0]), split[1]);
                    BuildingDecoration buildingDecoration = new BuildingDecoration();
                    buildingDecoration.getSubBuildingDecorationList().add(subBuildingDecoration1);
                    buildingDecorationRepository.create(buildingDecoration);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
