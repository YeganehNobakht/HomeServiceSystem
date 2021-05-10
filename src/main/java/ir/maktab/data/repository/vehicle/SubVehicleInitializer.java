package ir.maktab.data.repository.vehicle;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import ir.maktab.data.entity.vehicle.SubVehicle;
import ir.maktab.data.entity.vehicle.Vehicles;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class SubVehicleInitializer {
    private final SubVehicleRepository subVehicleRepository;
    private final VehiclesRepository vehiclesRepository;

    public SubVehicleInitializer(SubVehicleRepository subVehicleRepository,
                                            VehiclesRepository vehiclesRepository) {
        this.subVehicleRepository = subVehicleRepository;
        this.vehiclesRepository = vehiclesRepository;
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
                    SubVehicle subVehicle = new SubVehicle(key.toString(), Double.valueOf(split[0]), split[1]);
                    Vehicles vehicles = new Vehicles();
                    vehicles.getSubVehicleArrayList().add(subVehicle);
                    vehiclesRepository.create(vehicles);
                    //  subBuildingDecorationRepository.create();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
