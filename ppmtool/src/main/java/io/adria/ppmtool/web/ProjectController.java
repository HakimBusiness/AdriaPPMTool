package io.adria.ppmtool.web;

import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("")
    ResponseEntity<?> addProject(@Valid  @RequestBody project p, BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String,String> errorMap=new HashMap<>();
            for(FieldError err:result.getFieldErrors())
            {
                errorMap.put(err.getField(),err.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
        }
        project p1=projectService.saveOrUpdateProject(p);
        return new ResponseEntity<project>(p, HttpStatus.CREATED);
    }
}
