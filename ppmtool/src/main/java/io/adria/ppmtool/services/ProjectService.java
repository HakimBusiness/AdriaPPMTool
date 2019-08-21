package io.adria.ppmtool.services;

import io.adria.ppmtool.domain.User;
import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.exceptions.ProjectIdException;
import io.adria.ppmtool.repositories.ProjectRepository;
import io.adria.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
     UserRepository userRepository;

    public project saveOrUpdateProject(project p,String username)
    {
        try{
            User user = userRepository.findByUsername(username);
            p.setUser(user);
            p.setProjectLeader(user.getUsername());
            p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
            return projectRepository.save(p);
        }
        catch (Exception e){
           throw new ProjectIdException("Project ID "+p.getProjectIdentifier()+" Already exists !");
        }

    }
    public project findProject(String identifier)
    {
            project p=projectRepository.findByProjectIdentifier(identifier);
            if(p==null) throw new ProjectIdException("Project doesn't exist !");
            return p;
    }

    public Iterable<project> findAll(){
        return projectRepository.findAll();
    }

    public void deleteById(String Id)
    {
        project p=projectRepository.findByProjectIdentifier(Id);
        if(p==null) throw new ProjectIdException("Project with identifier "+Id+" doesn't exist !");
        projectRepository.delete(p);
    }
}
