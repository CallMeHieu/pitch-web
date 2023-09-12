package com.techpower.pitchweb.manager;

import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.model.Address;
import com.techpower.pitchweb.model.Pitch;
import com.techpower.pitchweb.service.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class AddressManager extends BaseManager<Address> {
    @Autowired
    private GeocodingService geocodingService;

    public AddressManager() {
        super("address", Address.class);
    }

    public Address createAddress(String fullAddress, String currentUserId, String pitchId) throws IOException, InterruptedException, ApiException {
        Address address = new Address();
        address.setPitchId(pitchId);
        address.setFullAddress(fullAddress);
        address.setCurrentUserId(currentUserId);
        LatLng latLng = geocodingService.getLatLngFromAddress(fullAddress);
        if (latLng == null) {
            address.setLat(0);
            address.setLng(0);
        } else {
            address.setLat(latLng.lat);
            address.setLng(latLng.lng);
        }
        create(address, currentUserId);
        return address;
    }
}
