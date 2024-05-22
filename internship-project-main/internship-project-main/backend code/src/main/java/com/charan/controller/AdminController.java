package com.charan.controller;

import com.charan.entity.Admin;
import com.charan.entity.Task;
import com.charan.model.Login;
import com.charan.repo.AdminRepo;
import com.charan.repo.LeaveRepo;
import com.charan.service.Adminsrvimp;
import com.charan.service.Leavesrvimp;
import com.charan.service.Tasksrvimp;
import com.charan.service.Usersrvimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private Adminsrvimp adminsrvimp;
    @Autowired
    private Tasksrvimp tasksrvimp;
    @Autowired
    private Leavesrvimp leavesrvimp;
    @Autowired
    private Usersrvimp usersrvimp;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Admin admin  )
    {
        return adminsrvimp.registration(admin);
    }
    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Login login )
    {

        return adminsrvimp.login(Integer.parseInt(login.getLogin_id()), login.getPassword());
    }
    @PostMapping("/createTask/{uId}")
    public ResponseEntity<Object>  createTask(@RequestBody Task task,@PathVariable String uId)
    {
         return tasksrvimp.createTask(task,uId);
    }
   @GetMapping("/userLeaves")
    public ResponseEntity<Object> userLeaves()
   {
       return leavesrvimp.UserLeaves();
   }
   @PutMapping("/changeLeaveStatus/{lId}/{status}")
   public  ResponseEntity<Object> changeLeaveStatus(@PathVariable String lId,@PathVariable String status)
   {
        return leavesrvimp.changeLeaveStatus(lId,status);
   }
  @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers()
  {
      return new ResponseEntity<>(usersrvimp.getAllUsers(), HttpStatus.OK);
  }
}
