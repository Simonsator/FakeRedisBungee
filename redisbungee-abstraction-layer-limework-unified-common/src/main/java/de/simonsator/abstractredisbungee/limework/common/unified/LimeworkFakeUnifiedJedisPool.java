package de.simonsator.abstractredisbungee.limework.common.unified;

import com.imaginarycode.minecraft.redisbungee.internal.jedis.UnifiedJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;

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
