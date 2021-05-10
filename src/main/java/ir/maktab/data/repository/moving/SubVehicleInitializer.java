package ir.maktab.data.repository.moving;

import ir.maktab.data.entity.moving.Moving;
import ir.maktab.data.entity.moving.SubMoving;
import ir.maktab.data.entity.vehicle.SubVehicle;
import ir.maktab.data.entity.vehicle.Vehicles;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubVehicleInitializer {
    private final SubMovingRepository subVehicleRepository;
    private final MovingRepository movingRepository;

    public SubVehicleInitializer(SubMovingRepository subMovingRepository,
                                 MovingRepository movingRepository) {
        this.subVehicleRepository = subMovingRepository;
        this.movingRepository = movingRepository;
    }

    @PostConstruct
    public void insertBuildingDecoration(){
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/main/resources/vehicle.properties"));
            //add data if database is empty.
            if (subVehicleRepository.getAll().isEmpty()){
                for (Object key : prop.keySet()) {
                    String[] split = prop.get(key).toString().split(",");
                    SubMoving subMoving = new SubMoving(key.toString(), Double.valueOf(split[0]), split[1]);
                    Moving moving = new Moving();
                    moving.getSubMovingList().add(subMoving);
                    movingRepository.create(moving);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
