package com.blogs.dashboard.controller;

import com.blogs.dashboard.model.comment;
import com.blogs.dashboard.model.dashboardModel;
import com.blogs.dashboard.model.tempResponse;
import com.blogs.dashboard.service.dashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class dashboardController
{
    @Autowired
    dashboardService service;

    @PostMapping("/addBlogs")
    public ResponseEntity<?> addB(@RequestBody  dashboardModel model)
    {
        return new ResponseEntity<>(service.addBlog(model), HttpStatus.CREATED);
    }
    @GetMapping("/showBlogs")
    public ResponseEntity<?> shoB()
    {
        List<dashboardModel> dm=service.showBlogs();
        return new ResponseEntity<>(dm, HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public ResponseEntity<?> addC(@RequestBody comment com)
    {
        return new ResponseEntity<>(service.addComm(com),HttpStatus.OK);
    }
    @GetMapping("getComments/{vId}")
    public ResponseEntity<?> showC(@PathVariable int vId)
    {
        return new ResponseEntity<>(service.showCom(vId),HttpStatus.OK);
    }
}
