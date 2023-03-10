package com.rest.question.survey.restapisurveyquestion.base;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponsePage<T> {
    private Integer totalPage;
    private Integer currentPage;
    private Long totalElement;
    private T content;
}
 
