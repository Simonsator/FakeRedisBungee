package de.simonsator.abstractredisbungee.events;

import java.util.UUID;

public class PlayerJoinedNetworkManager extends GenericListenerManager<PlayerJoinedNetworkListener> {
	private static PlayerJoinedNetworkManager instance;

	public PlayerJoinedNetworkManager() {
		instance = this;
	}

	public static PlayerJoinedNetworkManager getInstance() {
		return instance;
	}

	public void playerJoinedNetwork(UUID pPlayerUUID) {
		LISTENERS.forEach(listener -> listener.onPlayerJoinedNetwork(pPlayerUUID));
	}
}
