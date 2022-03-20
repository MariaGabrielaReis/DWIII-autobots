package com.autobots.automanager.model;

import java.util.List;


public interface AdderLink<T> {
	public void addLink(List<T> list);
	public void addLink(T object);
}