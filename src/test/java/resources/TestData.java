package resources;

import pojo.AddPlaceRequest;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public AddPlaceRequest addPLacePayload(String name , String language, String address){


        AddPlaceRequest addPlaceRequest = new AddPlaceRequest();
        addPlaceRequest.setAccuracy(50);
        addPlaceRequest.setAddress(address);
        addPlaceRequest.setLanguage(language);
        addPlaceRequest.setPhone_number("(+91)7760557517");
        addPlaceRequest.setName(name);
        List<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");
        addPlaceRequest.setTypes(types);

        Location location = new Location();
        location.setLng(33.427362);
        location.setLat(-38.383494);
        addPlaceRequest.setLocation(location);
        return addPlaceRequest;


    }
}
