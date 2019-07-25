package io.adria.ppmtool.web;

import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("")
    ResponseEntity<project> addProject(@RequestBody project p)
    {
        project p1=projectService.saveOrUpdateProject(p);
        return new ResponseEntity<project>(p, HttpStatus.CREATED);
    }
}
