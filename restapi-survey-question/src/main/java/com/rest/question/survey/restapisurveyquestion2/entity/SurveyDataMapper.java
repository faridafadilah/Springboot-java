package com.rest.question.survey.restapisurveyquestion.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="survey")
public class SurveyDataMapper {
  @Id
  private String id;
  private String title;
  private String description;

  @OneToMany(mappedBy = "survey")
  private List<QuestionDataMapper> questions;
}
