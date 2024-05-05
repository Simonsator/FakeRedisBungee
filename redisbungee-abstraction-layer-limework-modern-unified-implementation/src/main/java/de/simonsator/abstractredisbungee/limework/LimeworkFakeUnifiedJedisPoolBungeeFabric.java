package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungee;
import de.simonsator.abstractredisbungee.limework.common.unified.LimeworkFakeUnifiedJedisPool;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class LimeworkFakeUnifiedJedisPoolBungeeFabric {
	public static LimeworkFakeUnifiedJedisPool create() {
		Plugin redisBungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
		if (redisBungee != null) {
			RedisBungee redisBungeeInstance = (RedisBungee) redisBungee;
			return new LimeworkFakeUnifiedJedisPool(redisBungeeInstance.proxyDataManager().unifiedJedis());
		}
		throw new RuntimeException("Could not load UnifiedJedisPool from Limework fork of RedisBungee");
	}

}
