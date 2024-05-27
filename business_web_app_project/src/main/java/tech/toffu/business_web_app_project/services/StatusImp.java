package tech.toffu.business_web_app_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.toffu.business_web_app_project.models.Status;
import tech.toffu.business_web_app_project.repositories.StatusRepository;

@Service
public class StatusImp implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

}
