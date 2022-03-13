package com.autobots.automanager.modelos;

import java.util.List;


public interface AdderLink<T> {
	public void addLink(List<T> list);
	public void addLink(T object);
}