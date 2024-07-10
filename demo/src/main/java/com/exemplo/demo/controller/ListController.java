package com.exemplo.demo.controller;

import com.exemplo.demo.dto.AddItemRequest;
import com.exemplo.demo.dto.ListDTO;
import com.exemplo.demo.entity.Lists;
import com.exemplo.demo.service.ListServ;
import com.exemplo.demo.util.SecurityUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/list")
public class ListController {

    private final ListServ listServ;

    @Autowired
    public ListController(ListServ listServ) {
        this.listServ = listServ;
    }

    @PostMapping
    public ResponseEntity<Lists> addItem(@RequestBody @Valid AddItemRequest request) {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            Lists list = listServ.addItemToList(userEmail, request.getMediaId());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListDTO>> listLists() {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            List<ListDTO> carts = listServ.getListsForUser(userEmail);
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<Void> removeFromList(@PathVariable Integer mediaId) {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            listServ.removeItemFromList(userEmail, mediaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}