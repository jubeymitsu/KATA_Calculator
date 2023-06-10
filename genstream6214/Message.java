package com.genstream6214;

public interface Message<T> {

    String getFrom();

    String getTo();

    T getContent();
}
