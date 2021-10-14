package com.LetsConnect.please.service;

import com.LetsConnect.please.domain.AppUser;
import com.LetsConnect.please.domain.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers(); // this will load to many user for bigger application so in the future just do a page at a time
}
