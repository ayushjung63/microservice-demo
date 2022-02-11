package com.ayush.accountservice.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum ResponseStatus {
    FAIL,SUCCESS
}
