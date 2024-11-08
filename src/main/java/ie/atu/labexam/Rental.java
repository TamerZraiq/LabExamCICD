package ie.atu.labexam;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Pattern(regexp = "RENT+-+1234")
    private String rentalCode;

    @Size(max = 50, message = "Exceeded 50 characters")
    private String carModel;

    @NotBlank(message = "Name must not be empty")
    private String renterName;

    @Email(message = "Invalid Email Address")
    private String renterEmail;

    @PastOrPresent
    private Date rentalStartDate;

    @FutureOrPresent
    private Date rentalEndDate;

    @PositiveOrZero
    private float dailyRate;
}
