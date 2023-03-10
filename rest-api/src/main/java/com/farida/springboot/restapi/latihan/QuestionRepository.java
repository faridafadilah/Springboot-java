package com.farida.springboot.restapi.latihan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String>  {
  // SELECT s.id, s.title, q.question_id, q.correct_answer  FROM question q INNER JOIN survey s ON s.id = q.survey_id
	@Query(
    value = "SELECT s.id as idSurvey, s.title as titleSurvey, q.id as idQuestion, q.correct_answer as correctAnswer " +
    "FROM question q INNER JOIN survey s ON s.id = q.survey_id ",
    nativeQuery = true
  )
  List<QuestionDto> getAllQuestion();
}
