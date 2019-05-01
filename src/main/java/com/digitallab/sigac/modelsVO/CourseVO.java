package com.digitallab.sigac.modelsVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseVO extends EntityHeritageVO {
    private String grade;
    private String gradeNumber;
    private int idTeacher;
}
