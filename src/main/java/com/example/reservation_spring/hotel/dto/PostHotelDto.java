package com.example.reservation_spring.hotel.dto;


import com.example.reservation_spring.hotel.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostHotelDto {

    private String title;      // 숙박 글 제목
    private String hotelName;  // 호텔 이름
    private int price;         // 가격
    private int capacity;      // 수용 인원
    private String description; // 호텔 설명
    private String address;    // 호텔 주소
    private Date date;         // 예약 날짜
    private boolean isReserved; // 예약 유무
    private String imageUrl;   // 호텔 이미지 URL
    private Long businessId;   // Business ID


    public Hotel toEntity() {
        return Hotel.builder()
                .title(title)
                .hotelName(hotelName)
                .price(price)
                .capacity(capacity)
                .description(description)
                .address(address)
                .date(date)
                .isReserved(isReserved)
                .imageUrl(imageUrl)
                .businessId(businessId)
                .build();
    }
}
