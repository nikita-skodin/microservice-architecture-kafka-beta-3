package com.skodin.DTO;

import com.skodin.models.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDTO {

    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

}