package com.example.backonlinestore.Service;

public enum ReportType {

    EXECUTION_TIME(1L);


    private final Long id;


    ReportType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
