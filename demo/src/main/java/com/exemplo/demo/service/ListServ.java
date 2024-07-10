package com.exemplo.demo.service;

import com.exemplo.demo.dto.ListDTO;
import com.exemplo.demo.dto.MediaDTO;
import com.exemplo.demo.entity.Lists;
import com.exemplo.demo.entity.Media;
import com.exemplo.demo.entity.Users;
import com.exemplo.demo.repository.ListRepository;
import com.exemplo.demo.repository.MediaRepository;
import com.exemplo.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListServ {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Transactional
    public Lists addItemToList(String userEmail, Integer mediaId) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Media media = mediaRepository.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));

        Optional<Lists> ListOptional = listRepository.findByUser(user);
        Lists list;
        if (ListOptional.isPresent()) {
            list = ListOptional.get();
        } else {
            list = new Lists();
            list.setUser(user);
            list.setListItems(new ArrayList<>());
        }

        list.getListItems().add(media);
        return listRepository.save(list);
    }

    public List<ListDTO> getListsForUser(String userEmail) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        List<Lists> lists = listRepository.findAllByUser(user);

        return lists.stream().map(this::convertToListDTO).collect(Collectors.toList());
    }

    private ListDTO convertToListDTO(Lists lists) {
        ListDTO listDTO = new ListDTO();
        listDTO.setId(lists.getId());
        listDTO.setCreatedAt(lists.getCreatedAt());
        List<MediaDTO> listItems = lists.getListItems().stream().map(MediaDTO::fromEntity).collect(Collectors.toList());
        listDTO.setListItems(listItems);
        return listDTO;
    }

    @Transactional
    public void removeItemFromList(String userEmail, Integer mediaId) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Media media = mediaRepository.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));

        Lists lists = listRepository.findByUser(user).orElseThrow(() -> new RuntimeException("List not found"));
        lists.getListItems().remove(media);
        listRepository.save(lists);
    }

}
