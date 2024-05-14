package de.simonsator.abstractredisbungee.velocity.limework;

import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import de.simonsator.abstractredisbungee.limework.common.unified.LimeworkFakeUnifiedJedisPool;

public class LimeworkRedisVelocityAPIUnifiedJedis extends LimeworkRedisVelocityAbstractAPI {
	private LimeworkFakeUnifiedJedisPool pool = null;
	private final ProxyServer PROXY_SERVER;

	public LimeworkRedisVelocityAPIUnifiedJedis(ProxyServer pProxyServer, Object pMainPluginObject) {
		super(pProxyServer, pMainPluginObject);
		PROXY_SERVER = pProxyServer;
	}

	public static boolean isCompatible() {
		try {
			Class.forName("com.imaginarycode.minecraft.redisbungee.api.ProxyDataManager");
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}

	@Override
	public FakeJedisPool getPool() {
		if (pool == null) {
			pool = new LimeworkFakeUnifiedJedisPool();
		}
		return pool;
	}
}
