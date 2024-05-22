package com.charan.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.charan.entity.User;
import com.charan.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charan.repo.LeaveRepo;
import com.charan.entity.Leave;

@Service
public class Leavesrvimp implements Leavesrv
{
    @Autowired
    private LeaveRepo leaveRepo;
    @Autowired
    private UserRepo userRepO;
    public ResponseEntity<Object> createLeave(Leave leave, String uId)
    {
        Optional<User> useropt= userRepO.findByUid(uId);
        if(useropt.isPresent())
        {
            User user=useropt.get();
            if(Optional.of(useropt.get().leave).isPresent())
            {
                leave.setUse(user);
                List<Leave>leaves=user.getLeave();
                 leaves.add(leave);
                 leave.setStatus("pending");
                 userRepO.save(user);
                 return new ResponseEntity(userRepO.save(user).getLeave().stream().filter(leave1 -> leave1.getLid().equals(leave.getLid())).findFirst(),
                         HttpStatus.CREATED);
            }
           else {
               List<Leave> leaves=new ArrayList<>();
                    leave.setUse(user);
                    leaves.add(leave);
                    userRepO.save(user);
                leave.setStatus("pending");
                return new ResponseEntity(userRepO.save(user).getLeave().stream().filter(leave1 -> leave1.getLid().equals(leave.getLid())).findFirst()
                        , HttpStatus.CREATED);
           }}
           else
            {
                return new ResponseEntity("uidwrong  ", HttpStatus.BAD_REQUEST);
            }


    }
    public ResponseEntity<Object> leaveStatus(String lId)
    {
        return new ResponseEntity<>(leaveRepo.findByLid(lId).get(),HttpStatus.OK);
    }
    public ResponseEntity<Object>UserLeaves()
    {
        List<Leave> leaves=leaveRepo.findAll();
        List<Leave> leaves1= leaves.stream().
                filter(leave->LocalDate.now().
                        compareTo(LocalDate.parse(leave.getStdte(),DateTimeFormatter.ofPattern("d/MM/yyyy")))<0
                && leave.getStatus().equals("pending")).collect(Collectors.toList());
           return new ResponseEntity<>(leaves1,HttpStatus.OK);
    }
    public ResponseEntity<Object>  changeLeaveStatus(String lId,String status )

    {
        Leave leave1=leaveRepo.findByLid(lId).get();
        leave1.setStatus(status);
        leaveRepo.save(leave1);
        return new ResponseEntity<>(leave1,HttpStatus.OK);

    }
}
