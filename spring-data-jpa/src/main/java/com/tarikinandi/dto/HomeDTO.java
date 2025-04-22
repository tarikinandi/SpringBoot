package com.tarikinandi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDTO {

    private Long id;
    private BigDecimal price;
    private List<RoomDTO> room = new ArrayList<>();
}
