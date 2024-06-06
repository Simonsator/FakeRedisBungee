package de.simonsator.abstractredisbungee.events;

import java.util.UUID;

public class PlayerLeftNetworkManager extends GenericListenerManager<PlayerLeftNetworkListener> {
	private static PlayerLeftNetworkManager instance;

	public PlayerLeftNetworkManager() {
		instance = this;
	}

	public static PlayerLeftNetworkManager getInstance() {
		return instance;
	}

	public void playerLeftNetwork(UUID pPlayerUUID) {
		LISTENERS.forEach(listener -> listener.onPlayerLeftNetwork(pPlayerUUID));
	}
}
