package ie.atu.labexam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private List<Rental> rentalList = new ArrayList<>();
    private RentalService myService;

    public RentalController(RentalService myService){
        this.myService = myService;
    }
    @GetMapping("/{rentalCode}")
    public List<Rental> getRentalList(@PathVariable String rentalCode){
        rentalList = myService.getRental(rentalCode);
        return rentalList;
    }
    @PostMapping("/createRental")
    public List<Rental> newRental(@Valid@RequestBody Rental rental){
        rentalList = myService.addRental(rental);
        return rentalList;
    }
    @PutMapping("/{rentalCode}")
    public List<Rental> editRental(@Valid@PathVariable String rentalCode, @RequestBody Rental rental){
        rentalList = myService.updateRental(rentalCode, rental);
        return rentalList;
    }
    @DeleteMapping("/{rentalCode}")
    public List<Rental> removeRental(@Valid@PathVariable String rentalCode){
        rentalList = myService.deleteRental(rentalCode);
        return rentalList;
    }

}
