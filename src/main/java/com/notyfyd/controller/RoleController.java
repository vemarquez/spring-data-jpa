package com.notyfyd.controller;

import com.notyfyd.entity.Role;
import com.notyfyd.repository.RoleRepository;
import com.notyfyd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RoleController {

    private RoleService roleService;
    private RoleRepository roleRepository;

    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
            return  roleService.addRole(role);
    }
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping("/role/details/{id}")
    public Role getRole(@PathVariable Long  id) {
        return roleRepository.findById(id).get();
    }
    @GetMapping("/role/all")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
