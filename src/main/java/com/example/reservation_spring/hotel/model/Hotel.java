package com.example.reservation_spring.hotel.model;


import com.example.reservation_spring.business.model.Business;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class Hotel {

    private Long id;
    private String title;     // 숙박 글 제목
    private String hotelName; // 호텔 이름
    private int price;        // 가격
    private int capacity;     // 수용 인원
    private String description; // 호텔 설명
    private String address;   // 호텔 주소
    private Date date;   // 예약 날짜
    private boolean isReserved; // 예약 유무
    private String imageUrl;  // 호텔 이미지 URL
    private Long businessId;  // Foreign Key - Business ID
    private Business business;  // Business 객체 추가 (FK 연관)
}
