package com.valros.ux.services.smartrash.controllers;


import com.valros.ux.services.controller.CommunitiesApi;
import com.valros.ux.services.model.Community;
import com.valros.ux.services.smartrash.services.ICommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${application.api.base-path}")
public class CommunityController implements CommunitiesApi {

    @Autowired
    private ICommunityService iCommunityService;

    @Override
    public ResponseEntity<Community> communityUpdateById(String communityId, Community community) {
        try {
            return ResponseEntity.ok(iCommunityService.updateCommunity(community));
        } catch (Exception e) {
            log.error("Error retrieving communityUpdateById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> communityDeleteById(String communityId) {
        try {
            return iCommunityService.deleteCommunityById(communityId);
        } catch (Exception e) {
            log.error("Error retrieving communityDeleteById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Community>> getAllCommunities() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iCommunityService.getAllCommunities());
        } catch (Exception e) {
            log.error("Error retrieving getAllCommunities", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Community> getCommunityById(String communityId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iCommunityService.getCommunityById(communityId));
        } catch (Exception e) {
            log.error("Error retrieving getCommunityById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Community> postCreateCommunity(Community community) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iCommunityService.createCommunity(community));
        } catch (Exception e) {
            log.error("Error retrieving postCreateCommunity", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
