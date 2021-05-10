package ir.maktab.data.repository.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubBuildingDecorationInitializer {
    private final SubBuildingDecorationRepository subBuildingDecorationRepository;
    private final Environment environment;

    public SubBuildingDecorationInitializer(SubBuildingDecorationRepository subBuildingDecorationRepository, Environment environment) {
        this.subBuildingDecorationRepository = subBuildingDecorationRepository;
        this.environment = environment;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/buildingDecoration.properties"));
            System.out.println(prop);
            for (Object key : prop.keySet()){
                String[] split = prop.get(key).toString().split(",");
                subBuildingDecorationRepository.create(new SubBuildingDecoration(key.toString(),Double.valueOf(split[0]),split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
