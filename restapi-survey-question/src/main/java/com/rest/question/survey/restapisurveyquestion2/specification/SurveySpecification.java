package com.rest.question.survey.restapisurveyquestion2.specification;

import java.util.Arrays;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.rest.question.survey.restapisurveyquestion2.base.BaseSpecification;
import com.rest.question.survey.restapisurveyquestion2.entity.SurveyDataMapper;

@Component
public class SurveySpecification extends BaseSpecification<SurveyDataMapper> {
  @Override
	public Specification<SurveyDataMapper> containsTextInOmni(String text) {
		return containsTextInAttributes(text,
				Arrays.asList("description", "transactionNumber", "transactionType", "platform"));
	}
}
 