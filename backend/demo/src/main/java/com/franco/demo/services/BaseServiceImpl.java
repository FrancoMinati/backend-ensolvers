package com.franco.demo.services;

import com.franco.demo.domain.Base;
import com.franco.demo.dtos.BaseDto;
import com.franco.demo.exceptions.ServicioException;
import com.franco.demo.mapper.BaseMapper;
import com.franco.demo.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseServiceImpl<E extends Base, D extends BaseDto, ID extends Serializable> implements BaseService<E, D, ID> {
    protected BaseRepository<E,ID> baseRepository;

    protected BaseMapper<E, D> baseMapper;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository, BaseMapper<E, D> baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    @Override
    @Transactional
    public List<D> findALL() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return baseMapper.toDTOsList(entities);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<D> findALL(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities.map(baseMapper::toDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public D findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            if(entityOptional.isEmpty()) {
                throw new ServicioException("No se encontro la entidad con el id dado.");
            }

            return baseMapper.toDTO(entityOptional.get());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public D save(D dto) throws Exception {
        try{
            E entity = baseRepository.save(baseMapper.toEntity(dto));
            return baseMapper.toDTO(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public D update(ID id, D dto) throws ServicioException {
        try{
            if (dto.getId() == null) {
                throw new ServicioException("La entidad a modificar debe contener un Id.");
            } else if(!id.equals(dto.getId())){
                throw new ServicioException("El id enviado como parametro y el id de la entidad deben coincidir.");
            }

            Optional<E> entityOptional = baseRepository.findById(id);

            if(entityOptional.isEmpty()) {
                throw new ServicioException("No se encontro la entidad con el id dado.");
            }

            E entityUpdate = baseRepository.save(baseMapper.toEntity(dto));
            return baseMapper.toDTO(entityUpdate);
        } catch (Exception e){
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
