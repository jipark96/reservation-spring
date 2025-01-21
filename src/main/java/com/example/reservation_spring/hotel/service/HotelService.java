package com.example.reservation_spring.hotel.service;

import com.example.reservation_spring.hotel.dto.PostHotelDto;
import com.example.reservation_spring.hotel.model.Hotel;
import com.example.reservation_spring.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {

    private final HotelRepository hotelRepository;

//    // 글(호텔) 등록
//    public void createHotel(Hotel hotel) {
//        hotelRepository.createHotel(hotel);
//    }


    // 글(호텔) 등록
    public void createHotel(PostHotelDto postHotelDto) {

        Hotel hotel = postHotelDto.toEntity();

        hotelRepository.createHotel(hotel);
    }
}
