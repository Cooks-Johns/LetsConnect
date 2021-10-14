package com.LetsConnect.please.service;

import com.LetsConnect.please.domain.AppUser;
import com.LetsConnect.please.domain.Role;
import com.LetsConnect.please.repo.RoleRepo;
import com.LetsConnect.please.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


// Issue with having getName() working

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }


    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new User: {} to the database"); // ,user.getName()
        return userRepo.save(user);
    }
    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role: {} to the database", role.getClass()); // ,role.getName()
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding Role: {} to User: {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching User: {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Stand back fetching all Users!!!");
        return userRepo.findAll();
    }
}
