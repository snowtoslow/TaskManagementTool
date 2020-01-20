package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "state")
public enum State {
    @Column(name = "state")
    TO_DO, DONE, IN_PROGRESS, WAITING_FOR_APPROVEMENT
}
