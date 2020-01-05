package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "state")
public enum State {
    @Column(name = "state")
    CURRENT, FINISHED, IN_PROGRESS, PAUSED, W84A
}
