package de.simonsator.abstractredisbungee.velocity.limework;

import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import de.simonsator.abstractredisbungee.limework.common.LimeworkFakeJedisPool;

public class LimeworkRedisVelocityAPI extends LimeworkRedisVelocityAbstractAPI {

	public LimeworkRedisVelocityAPI(ProxyServer pProxyServer, Object pMainPluginObject) {
		super(pProxyServer, pMainPluginObject);
	}

	public static boolean isCompatible() {
		try {
			Class.forName("com.imaginarycode.minecraft.redisbungee.internal.jedis.JedisPool");
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}

	@Override
	public FakeJedisPool getPool() {
		return new LimeworkFakeJedisPool(API);
	}
}
