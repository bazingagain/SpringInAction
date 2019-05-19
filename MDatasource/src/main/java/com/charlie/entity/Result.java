package com.charlie.entity;

import lombok.Data;

@Data
public class Result {
    private final long id;
    private final int left;
    private final int right;
    private final int answer;
}
