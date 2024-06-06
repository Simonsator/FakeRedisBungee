package de.simonsator.abstractredisbungee;

import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.abstractredisbungee.invk.InvvkRedisVelocityAPI;
import de.simonsator.abstractredisbungee.velocity.limework.LimeworkRedisVelocityAPI;
import de.simonsator.abstractredisbungee.velocity.limework.LimeworkRedisVelocityAPIUnifiedJedis;

public class FakeRedisVelocityInit {
	public static boolean init(ProxyServer pProxyServer, Object pMainPluginObject) {
		if (InvvkRedisVelocityAPI.isCompatible()) {
			new InvvkRedisVelocityAPI(pProxyServer, pMainPluginObject);
			return true;
		}
		if (LimeworkRedisVelocityAPIUnifiedJedis.isCompatible()) {
			new LimeworkRedisVelocityAPIUnifiedJedis(pProxyServer, pMainPluginObject);
			return true;
		}
		if (LimeworkRedisVelocityAPI.isCompatible()) {
			new LimeworkRedisVelocityAPI(pProxyServer, pMainPluginObject);
			return true;
		}
		return false;
	}
}
