package io.adria.ppmtool.exceptions;

public class ProjectIdExceptionResponse {
     String projectException;

    public ProjectIdExceptionResponse(String projectException) {
        this.projectException = projectException;
    }

    public String getProjectException() {
        return projectException;
    }

    public void setProjectException(String projectException) {
        this.projectException = projectException;
    }
}
