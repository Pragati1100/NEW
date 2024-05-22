package com.charan.controller;

import com.charan.entity.Admin;
import com.charan.entity.Leave;
import com.charan.entity.User;
import com.charan.model.Login;
import com.charan.repo.LeaveRepo;
import com.charan.repo.TaskRepo;
import com.charan.service.Leavesrvimp;
import com.charan.service.Tasksrvimp;
import com.charan.service.Usersrvimp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    Usersrvimp usersrvimp;
    @Autowired
    Leavesrvimp leavesrvimp;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    Tasksrvimp tasksrvimp;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user  )
    {
       return usersrvimp.registration(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Login login )
    {
        return usersrvimp.login(login.getLogin_id(), login.getPassword());
    }
    @PostMapping("/createLeave/{uId}")
    public ResponseEntity<Object> createLeave(@RequestBody Leave leave, @PathVariable String uId)
    {
        return  leavesrvimp.createLeave(leave,uId);
    }
    @PostMapping("/leaveStatus/{lId}")
    public ResponseEntity<Object> LeaveStatus( @PathVariable String lId)
    {
        return  leavesrvimp.leaveStatus(lId);
    }
    @PutMapping("/changeTaskStatus/{tId}/{status}")
    public ResponseEntity<Object> changeStatus(@PathVariable String tId,@PathVariable String status )
    {

      return tasksrvimp.changeTaskStatus(tId, status);
    }
    @GetMapping("/getTask/{id}")
    public ResponseEntity<Object> getTask(@PathVariable String id )
    {
        return tasksrvimp.getTask(id);
    }

}
