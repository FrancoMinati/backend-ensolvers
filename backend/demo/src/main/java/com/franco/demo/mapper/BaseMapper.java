package com.franco.demo.mapper;


import com.franco.demo.domain.Base;
import com.franco.demo.dtos.BaseDto;

import java.util.List;

public interface BaseMapper<E extends Base, D extends BaseDto> {
    D toDTO(E source);
    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}
