package de.simonsator.abstractredisbungee.events;

import java.util.LinkedList;
import java.util.List;

public class GenericListenerManager<T> {
	protected final List<T> LISTENERS = new LinkedList<>();

	public void registerEventListener(T pReceiver) {
		LISTENERS.add(pReceiver);
	}

	public void unregisterEventListener(T pReceiver) {
		LISTENERS.remove(pReceiver);
	}
}
