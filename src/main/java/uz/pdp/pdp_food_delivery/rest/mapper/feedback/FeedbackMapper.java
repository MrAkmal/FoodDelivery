package uz.pdp.pdp_food_delivery.rest.mapper.feedback;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.Feedback;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;


@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FeedbackMapper extends BaseMapper<
        Feedback,
        FeedbackDto,
        FeedbackCreateDto,
        FeedbackUpdateDto> {

    Feedback fromCreateDto(FeedbackCreateDto feedbackCreateDto);

    Feedback fromUpdateDto(FeedbackUpdateDto feedbackUpdateDto);

    List<FeedbackDto> toDto(List<Feedback> feedback);

    FeedbackDto toDto(Feedback feedback);


}
