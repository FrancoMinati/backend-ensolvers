package com.franco.demo.services;

import com.franco.demo.domain.Base;
import com.franco.demo.dtos.BaseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, D extends BaseDto, ID extends Serializable>{
    public List<D> findALL() throws Exception;
    public Page<D> findALL(Pageable pageable) throws Exception;
    public D findById(ID id) throws Exception;
    public D save(D entity) throws Exception;
    public D update(ID id, D entity) throws Exception;
    public boolean delete(ID id) throws Exception;
}
