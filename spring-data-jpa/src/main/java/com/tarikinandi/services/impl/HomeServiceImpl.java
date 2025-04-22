package com.tarikinandi.services.impl;

import com.tarikinandi.dto.HomeDTO;
import com.tarikinandi.dto.RoomDTO;
import com.tarikinandi.entities.Home;
import com.tarikinandi.entities.Room;
import com.tarikinandi.repository.HomeRepository;
import com.tarikinandi.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;


    @Override
    public HomeDTO findHomeById(Long id) {
        HomeDTO homeDTO = new HomeDTO();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }

        Home home = optional.get();
        List<Room> rooms = optional.get().getRoom();

        BeanUtils.copyProperties(home, homeDTO);
        if (rooms.size() > 0){
            for (Room room : rooms){
                RoomDTO roomDTO = new RoomDTO();
                BeanUtils.copyProperties(room, roomDTO);
                homeDTO.getRoom().add(roomDTO);
            }
        }

        return homeDTO;
    }
}
