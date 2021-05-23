package ir.maktab.data.repository.initializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.serviceCategory.ServiceCategoryRepository;
import ir.maktab.data.repository.subCategory.SubCategoryRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@Component
public class ServiceAndSubServiceCategoryInitializer {

    private final ServiceCategoryRepository serviceCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public ServiceAndSubServiceCategoryInitializer(ServiceCategoryRepository serviceCategoryRepository, SubCategoryRepository subCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @PostConstruct
    public  void insertBuildingDecoration() throws IOException, ParseException {


        if (subCategoryRepository.getAll().isEmpty()) {
            Properties prop1 = new Properties();
            Properties prop2 = new Properties();
            ObjectMapper mapper = new ObjectMapper();
            SubCategory subCategory;

            prop1.load(new FileInputStream("src/main/resources/initialize/serviceCategory.properties"));
            prop2.load(new FileInputStream("src/main/resources/initialize/subCategory.properties"));


            for (Object reader1 : prop1.keySet()) {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(prop1.get(reader1).toString());
                JSONArray jsonArray = new JSONArray(obj.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    Iterator<String> keys = json.keys();

                    while (keys.hasNext()) {
                        String key = keys.next();
                        ServiceCategory serviceCategory = new ServiceCategory(json.get(key).toString());
                        serviceCategoryRepository.create(serviceCategory);
                        for (Object reader2 : prop2.keySet()) {
                            if (reader2.equals(json.get(key).toString())) {
                                JSONParser jsonParser2 = new JSONParser();
                                // System.out.println(prop2.get(reader2).toString());
                                Object obj2 = jsonParser2.parse(prop2.get(reader2).toString());
                                JSONArray jsonArray2 = new JSONArray(obj2.toString());
                                for (int k = 0; k < jsonArray2.length(); k++) {
                                    JSONObject json2 = jsonArray2.getJSONObject(k);
                                    Map subCategoryMap = mapper.readValue(json2.toString(), new TypeReference<Map>() {
                                    });
                                    //System.out.println(subCategoryMap);
                                    subCategory = new SubCategory(subCategoryMap.get("Name").toString(), subCategoryMap.get("Price").toString(), subCategoryMap.get("Comment").toString());
                                    //System.out.println(subCategory.getComment());
                                    subCategory.setServiceCategory(serviceCategory);
                                    subCategoryRepository.create(subCategory);
                                    //serviceCategory.getSubCategoryList().add(subCategory);
                                    //serviceCategoryRepository.create(serviceCategory);
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
