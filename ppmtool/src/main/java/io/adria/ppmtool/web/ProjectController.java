package io.adria.ppmtool.web;

import io.adria.ppmtool.domain.project;
import io.adria.ppmtool.services.MapValidationErrorService;
import io.adria.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    ResponseEntity<?> addProject(@Valid  @RequestBody project p, BindingResult result)
    {
        ResponseEntity<?> ValidationErrors=mapValidationErrorService.ErrorsMap(result);
        if(ValidationErrors!=null) return ValidationErrors;

        project p1=projectService.saveOrUpdateProject(p);
        return new ResponseEntity<project>(p, HttpStatus.CREATED);
    }
    @GetMapping("/{identifier}")
    ResponseEntity<?> findProject(@PathVariable String identifier)
    {
        project p =projectService.findProject(identifier.toUpperCase());
        return new ResponseEntity<project>(p,HttpStatus.OK);
    }
}
