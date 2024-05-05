package de.simonsator.abstractredisbungee.velocity.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeVelocityPlugin;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.abstractredisbungee.limework.common.unified.LimeworkFakeUnifiedJedisPool;

public class LimeworkFakeUnifiedJedisPoolVelocityFabric {
	public static LimeworkFakeUnifiedJedisPool create(ProxyServer pProxyServer) {
		return pProxyServer.getPluginManager().getPlugin("redisbungee")
				.flatMap(PluginContainer::getInstance)
				.filter(instance -> instance instanceof RedisBungeeVelocityPlugin)
				.map(instance -> (RedisBungeeVelocityPlugin) instance)
				.map(pluginInstance -> new LimeworkFakeUnifiedJedisPool(pluginInstance.proxyDataManager().unifiedJedis()))
				.orElseThrow(() -> new RuntimeException("Could not load UnifiedJedisPool from Limework fork of RedisBungee"));
	}
}
