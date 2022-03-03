package uz.pdp.pdp_food_delivery.rest.dto.meal;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;

import java.util.Date;

@Getter
@Setter
public class MealDto extends GenericDto {
    private byte[] picture;
    private String name;
    private Date date;
}
