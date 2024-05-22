package com.charan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.charan.entity.Leave;
import com.charan.entity.User;
import com.charan.model.UserModel;
import com.charan.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.charan.repo.TaskRepo;
import com.charan.entity.Task;

@Service
public class Tasksrvimp implements Tasksrv {

@Autowired
TaskRepo taskRepo;
@Autowired
UserRepo userRep0;
    public ResponseEntity<Object> createTask(Task task, String uId) {
        Optional<User> useropt = userRep0.findByUid(uId);
        if (useropt.isPresent()) {
            User user = useropt.get();
            if (Optional.of(useropt.get().leave).isPresent()) {
                task.setUser(user);
                List<Task> tasks = user.getTasks();
                tasks.add(task);
                task.setStts("not yet started");
                userRep0.save(user);
                return new ResponseEntity(userRep0.save(user).getTasks().stream().filter(task1 -> task1.getTsid().equals(task.getTsid())).findFirst(),
                        HttpStatus.CREATED);
            } else {
                List<Task> Tasks = new ArrayList<>();
                task.setUser(user);
                Tasks.add(task);
                userRep0.save(user);
                task.setStts("Not Yet started");
                return new ResponseEntity(userRep0.save(user).getTasks().stream().filter(task1 -> task1.getTsid().equals(task.getTsid())).findFirst()
                        , HttpStatus.CREATED);
            }
        } else {
            return new ResponseEntity("uidwrong  ", HttpStatus.BAD_REQUEST);
        }

    }
    public  ResponseEntity<Object> changeTaskStatus(String id,String status )
    {

         Task task=taskRepo.findByTsid(id).get();
         task.setStts(status);
         taskRepo.save(task);
         return new ResponseEntity<>(task,HttpStatus.OK);

    }
    public  ResponseEntity<Object> getTask(String uid )
    {
        User user=userRep0.findByUid(uid).get();
        List<Task> tasks=user.getTasks();
        return new ResponseEntity<>(tasks,HttpStatus.OK);

    }

    }
