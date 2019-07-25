package io.adria.ppmtool.services;

import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.exceptions.ProjectIdException;
import io.adria.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public project saveOrUpdateProject(project p)
    {
        try{
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
}
