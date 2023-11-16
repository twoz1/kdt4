package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.entity.GuestBook;

public interface GuestBookService {

	Long register(GuestBookDTO dto); // insert, update 모두사용
    List<GuestBook> selectList();
    GuestBook selectOne(Long gno);
    void delete(Long gno);
    
    // => Entity 와 DTO를 용도별로 분리해서 사용하는경우 필요함.
    //	  dtoToEntity() 와  entityToDto()
    default GuestBook dtoToEntity(GuestBookDTO dto) {
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestBookDTO entityToDto(GuestBook entity){

        GuestBookDTO dto  = GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
    
} //interface
