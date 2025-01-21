package com.example.reservation_spring.hotel.controller;


import com.example.reservation_spring.hotel.dto.PostHotelDto;
import com.example.reservation_spring.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "hotel 도메인", description = "글(호텔) API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

//    @Operation(summary = "호텔 등록")
//    @PostMapping("")
//    public ResponseEntity<String> createHotel(@RequestBody Hotel hotel) {
//        hotelService.createHotel(hotel);
//        return ResponseEntity.ok("호텔이 성공적으로 등록되었습니다.");
//    }


    @Operation(summary = "호텔 등록")
    @PostMapping("")
    public ResponseEntity<String> createHotel(@RequestBody PostHotelDto postHotelDto) {
        hotelService.createHotel(postHotelDto);
        return ResponseEntity.ok("호텔이 성공적으로 등록되었습니다.");
    }
}
