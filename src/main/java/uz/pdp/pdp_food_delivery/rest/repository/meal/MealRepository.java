package uz.pdp.pdp_food_delivery.rest.repository.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>, BaseRepository {

//    @Query(value = 'select * from books where name like \'%s\' limit \'%s\' offset :

//    List<Meal> getAllByLimit(@Param(value = "limit") Integer limitState, @Param(value = "offset") Integer offset);


    Optional<Meal> findByIdAndDeleted(Long id, boolean isDeleted);

    @Query(value = "select m.* from meal.meal m where m.photo_id = :photoId", nativeQuery = true)
    Meal findByPhotoId(@Param(value = "photoId") String photoId);
}
