package pl.sda.player.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    //private String licenceNumber;
    //private String dateOfBirth;
    //private String placeOfResidence;
    //private String dateStarting;
    //private String dateEnding;
    //private String ageCategory;
    private String sex;
   //private LocalDate dateOfBirth;

    //public String ageCategory(LocalDate now) {
// //      Period.between(dateOfBirth, now).getYears(); metoda liczy dokladnie od dnia urodzenia w tym
    //                                                  przypadku zbyt dokladna
     //   return "U" + (now.getYear() - dateOfBirth.getYear());  //ta metoda liczy wg rocznikow
    //}

    //private String trener;
    //private boolean isActive;
    //private String extraInfo;



}
