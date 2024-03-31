package com.franco.demo.repositories;

import com.franco.demo.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {}