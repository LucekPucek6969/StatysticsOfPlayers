package pl.sda.player.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Player {

    private int id;
    private String name;
    private String surname;
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String location;
    private String tel;
    private String licenceNumber;
    //private String dateEnding;
    //private String ageCategory;
    //private LocalDate dateOfBirth;


    public String ageCategory() {
        LocalDate currentDate = LocalDate.now();
        int s = Period.between(dateOfBirth, currentDate).getYears();

        if (s >= 23)
            return "senior";
        else if (s < 23 & s >= 20)
            return "U23";
        else if (s < 20 & s >= 18)
            return "U20";
        else if (s < 18 & s >= 16)
            return "U18";
        else if (s < 16 & s >= 14)
            return "U16";
        else if (s < 14 & s >= 12)
            return "U12";
        else
            return "U10";

    }
}




      //Period.between(LocalDate.(dateOfBirth), now).getYears();
      //  return "U" + (now.getYear() - dateOfBirth.getYear());  //ta metoda liczy wg rocznikow


    //private String trener;
    //private boolean isActive;
    //private String extraInfo;




