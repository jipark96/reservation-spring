package com.example.reservation_spring.hotel.repository;

import com.example.reservation_spring.hotel.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HotelRepository {

    private final SqlSessionTemplate sqlSession;

    // 글(호텔) 등록
    public void createHotel(Hotel hotel) {
        sqlSession.insert("com.example.reservation_spring.hotel.mapper.HotelMapper.createHotel", hotel);
    }
}
