package com.franco.demo.controller;


import com.franco.demo.domain.Base;
import com.franco.demo.dtos.BaseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends Base, D extends BaseDto, ID extends Serializable> {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody D dto);
    public ResponseEntity<?> update(@PathVariable ID id,@RequestBody D dto);
    public ResponseEntity<?> delete(@PathVariable ID id);
}
