import com.models.Cash;
import com.models.PropertyItem;
import com.models.enums.Currencies;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PropertyItemTest {
    @Test
    public void getPropertyFutureValue_Material_ok(){
        LocalDate calculationDate = LocalDate.of(2024,6,26);

        PropertyItem ordinateur = new PropertyItem("ordinateur",
                new Cash(2_000_000d, Currencies.ARIARY), LocalDate.of(2021,10,26),
                10.0);
        PropertyItem ordinateurFutureValue = ordinateur.getPropertyFutureValue(calculationDate);

        assertNotNull(ordinateurFutureValue.getCash().getBalance());
        assertEquals(1_466_302d, ordinateurFutureValue.getCash().getBalance());


    }
}
