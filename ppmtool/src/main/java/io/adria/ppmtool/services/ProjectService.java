package io.adria.ppmtool.services;

import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public project saveOrUpdateProject(project p)
    {
        return projectRepository.save(p);
    }
}
