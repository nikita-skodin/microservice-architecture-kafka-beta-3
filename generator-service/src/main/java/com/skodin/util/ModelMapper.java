package com.skodin.util;

import com.skodin.DTO.DataDTO;
import com.skodin.DTO.DataTestOptionsDTO;
import com.skodin.models.Data;
import com.skodin.models.test.DataTestOptions;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    private final org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public Data getData(DataDTO dto){
        return mapper.map(dto, Data.class);
    }

    public DataDTO getDataDTO(Data data){
        return mapper.map(data, DataDTO.class);
    }

    public DataTestOptions getDataTestOptions(DataTestOptionsDTO dto){
        return mapper.map(dto, DataTestOptions.class);
    }

    public DataTestOptionsDTO getDataTestOptionsDTO(DataTestOptions data){
        return mapper.map(data, DataTestOptionsDTO.class);
    }

}
