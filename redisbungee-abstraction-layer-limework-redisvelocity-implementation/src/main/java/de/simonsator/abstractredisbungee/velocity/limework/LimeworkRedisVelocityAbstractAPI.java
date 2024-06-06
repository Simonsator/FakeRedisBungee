package de.simonsator.abstractredisbungee.velocity.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import com.imaginarycode.minecraft.redisbungee.api.events.IPlayerJoinedNetworkEvent;
import com.imaginarycode.minecraft.redisbungee.api.events.IPlayerLeftNetworkEvent;
import com.imaginarycode.minecraft.redisbungee.events.PubSubMessageEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.ServerInfo;
import de.simonsator.abstractredisbungee.FakeRedisVelocityAPI;
import de.simonsator.abstractredisbungee.events.PlayerJoinedNetworkManager;
import de.simonsator.abstractredisbungee.events.PlayerLeftNetworkManager;
import de.simonsator.abstractredisbungee.events.PubSubMessageManager;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class LimeworkRedisVelocityAbstractAPI extends FakeRedisVelocityAPI {
	protected final RedisBungeeAPI API;

	public LimeworkRedisVelocityAbstractAPI(ProxyServer pProxyServer, Object pMainPluginObject) {
		super();
		API = RedisBungeeAPI.getRedisBungeeApi();
		pProxyServer.getEventManager().register(pMainPluginObject, this);
	}

	@Override
	public boolean isPlayerOnline(@NonNull UUID player) {
		return API.isPlayerOnline(player);
	}

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		return API.getServerFor(player);
	}

	@Override
	public void registerPubSubChannels(String... channels) {
		API.registerPubSubChannels(channels);
	}

	@Override
	public void sendChannelMessage(@NonNull String channel, @NonNull String message) {
		API.sendChannelMessage(channel, message);
	}

	@Subscribe
	public void onPubSubMessage(PubSubMessageEvent pEvent) {
		PubSubMessageManager.getInstance().invokePubSubMessageEvent(pEvent.getChannel(), pEvent.getMessage());
	}

	@Subscribe
	public void onPlayerJoinNetwork(IPlayerJoinedNetworkEvent pEvent) {
		PlayerJoinedNetworkManager.getInstance().playerJoinedNetwork(pEvent.getUuid());
	}

	@Subscribe
	public void onPlayerLeaveNetwork(IPlayerLeftNetworkEvent pEvent) {
		PlayerLeftNetworkManager.getInstance().playerLeftNetwork(pEvent.getUuid());
	}
}
