package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "priority")
public enum Priority {
    @Column(name = "priority")
    CRITICAL, SIGNIFICANT, MAJOR, MINOR, TRIVIAL

}