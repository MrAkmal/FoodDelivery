package uz.pdp.pdp_food_delivery.rest.service.dailymeal;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.mapper.dailymeal.DailyMealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.dailymeal.DailyMealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;
import java.util.Optional;

@Service
public class DailyMealService extends AbstractService<DailyMealMapper, DailyMealRepository>
        implements GenericCrudService<DailyMealCreateDto, DailyMealUpdateDto>, GenericService<DailyMealDto> {


    public DailyMealService(DailyMealMapper mapper, DailyMealRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(DailyMealUpdateDto dailyMealUpdateDto) {

    }

    @Override
    public Long create(DailyMealCreateDto dailyMealCreateDto) {
        DailyMeal dailyMeal = mapper.fromCreateDto(dailyMealCreateDto);
        DailyMeal save = repository.save(dailyMeal);
        return save.getId();
    }

    @Override
    public List<DailyMealDto> getAll() {
        return null;
    }

    @Override
    public DailyMealDto get(Long id) {
        DailyMeal dailyMeal = repository.findById(id).orElseThrow(() -> new RuntimeException("daily meal not found"));
        return mapper.toDto(dailyMeal);
    }

    public DailyMealDto get(String name) {
        Optional<DailyMeal> dailyMealOptional = repository.findByName(name);
        DailyMealDto dto = mapper.toDto(dailyMealOptional.get());
        return dto;
    }

    public List<MealDto> getAllByLimit(Pageable pageable) {
        Page<DailyMeal> all = repository.findAll(pageable);
        List<DailyMeal> dailyMeals = all.getContent();
        return mapper.toDto(dailyMeals);
    }


    public List<String> getAllName() {
        return repository.getAllName();
    }
}
