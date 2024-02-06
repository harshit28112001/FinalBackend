package com.blogs.dashboard.service;

import com.blogs.dashboard.model.comment;
import com.blogs.dashboard.model.dashboardModel;
import com.blogs.dashboard.repository.commentRepo;
import com.blogs.dashboard.repository.dashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class dashboardService implements dashboardServiceInterface {
    @Autowired
    dashboardRepository repo;
    @Autowired
    commentRepo cRepo;
    @Override
    public dashboardModel addBlog(dashboardModel model) {
        return repo.save(model);
    }

    @Override
    public List<dashboardModel> showBlogs() {
        return repo.findAll();
    }


    @Override
    public comment addComm(comment com) {
        cRepo.save(com);
        return com;
    }

    @Override
    public List<comment> showCom(int vId) {
        List<comment> coms =cRepo.findByVId(vId);
        return coms;
    }
}
