package ie.atu.labexam;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    private List <Rental> list = new ArrayList<>();
    public List<Rental> getRental(){
        return list;
    }
    public List<Rental> addRental(Rental rental){
        list.add(rental);
        return list;
    }
    public List<Rental> updateRental(@Valid@PathVariable String rentalCode, @RequestBody Rental rental){
        for(Rental r : list){
            if(r.getRentalCode() == rentalCode){
                list.remove(r);
            }
        }
        list.add(rental);
        return list;
    }
    public List<Rental> deleteRental(@Valid@PathVariable String rentalCode){
        for(Rental r : list){
            if(r.getRentalCode() == rentalCode){
                list.remove(r);
            }
        }
        return list;
    }

}
