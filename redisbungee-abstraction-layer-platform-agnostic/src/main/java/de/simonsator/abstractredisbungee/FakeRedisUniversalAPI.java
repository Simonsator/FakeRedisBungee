package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.events.PlayerJoinedNetworkManager;
import de.simonsator.abstractredisbungee.events.PlayerLeftNetworkManager;
import de.simonsator.abstractredisbungee.events.PubSubMessageManager;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class FakeRedisUniversalAPI {
	public FakeRedisUniversalAPI() {
		new PubSubMessageManager();
		new PlayerJoinedNetworkManager();
		new PlayerLeftNetworkManager();
	}

	public abstract FakeJedisPool getPool();

	public abstract boolean isPlayerOnline(@NonNull UUID player);

	public abstract void registerPubSubChannels(String... channels);

	public abstract void sendChannelMessage(@NonNull String channel, @NonNull String message);
}
