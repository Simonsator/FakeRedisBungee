package de.simonsator.abstractredisbungee.limework.common.unified;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import redis.clients.jedis.UnifiedJedis;

public class LimeworkFakeUnifiedJedisPool extends FakeJedisPool {
	private final UnifiedJedis SOURCE;

	public LimeworkFakeUnifiedJedisPool(UnifiedJedis pUnifiedJedis) {
		SOURCE = pUnifiedJedis;
	}

	@Override
	public FakeJedis getResource() {
		return new LimeworkFakeUnifiedJedis(SOURCE);
	}

	@Override
	public void close() {
	}
}
