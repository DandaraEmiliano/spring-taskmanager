package com.dandara.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Data Transfer Object for Task")
public class TaskDTO {


    @NotBlank(message = "Title is required")
    @Size(min = 3, message = "Title must have at least 3 characters")
    @Schema(description = "Title of the task", example = "Finish Spring Boot project", required = true)
    private String title;

    @Schema(description = "Description of the task", example = "Complete all steps of the CRUD")
    private String description;

    @NotBlank(message = "Status is required")
    @Schema(description = "Status of the task", example = "in progress", required = true)
    private String status;

    public TaskDTO() {
    }

    public TaskDTO(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
