package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import de.simonsator.abstractredisbungee.limework.common.unified.LimeworkFakeUnifiedJedisPool;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class ModernLimeworkRedisBungeeAPIUnified extends CommonLimeworkRedisBungeeAPI {
	private LimeworkFakeUnifiedJedisPool pool = null;

	public ModernLimeworkRedisBungeeAPIUnified(Plugin pPluginInstance) {
		super(pPluginInstance);
	}

	@SuppressWarnings("deprecation")
	public static boolean isCompatible() {
		try {
			Object redisbungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
			if (redisbungee instanceof com.imaginarycode.minecraft.redisbungee.RedisBungee) {
				Class.forName("com.imaginarycode.minecraft.redisbungee.api.ProxyDataManager");
				return RedisBungeeAPI.class.getMethod("getServerFor", UUID.class).
						getReturnType().getName().equals("net.md_5.bungee.api.config.ServerInfo");
			}
		} catch (Exception ignored) {
		}
		return false;
	}

	@Override
	public FakeJedisPool getPool() {
		if (pool == null) {
			pool = LimeworkFakeUnifiedJedisPoolBungeeFabric.create();
		}
		return pool;
	}

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		return API.getServerFor(player);
	}
}
