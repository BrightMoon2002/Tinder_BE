package com.codegym.controller.avatar;

import com.codegym.model.user.Avatar;
import com.codegym.service.avatar.IAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/avatar")
public class AvatarRestController {
    @Autowired
    IAvatarService avatarService;

    @GetMapping
    public ResponseEntity<Iterable<Avatar>> findAllAvatars() {
        return new ResponseEntity<>(avatarService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Avatar> saveAvatar(@RequestBody Avatar avatar) {
        avatarService.save(avatar);
        return new ResponseEntity<>(avatar,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avatar> updateAvatar(@PathVariable Long id, @RequestBody Avatar avatar) {
        Optional<Avatar> avatar1 = avatarService.findById(id);
        if (!avatar1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        avatar.setId(avatar1.get().getId());
        avatarService.save(avatar);
        return new ResponseEntity<>(avatar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avatar> findById(@PathVariable Long id) {
        Optional<Avatar> avatar = avatarService.findById(id);
        if (!avatar.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(avatar.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Avatar> delete(@PathVariable Long id) {
        Optional<Avatar> avatar = avatarService.findById(id);
        if (!avatar.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        avatarService.remove(id);
        return new ResponseEntity<>(avatar.get(), HttpStatus.NO_CONTENT);
    }
}

