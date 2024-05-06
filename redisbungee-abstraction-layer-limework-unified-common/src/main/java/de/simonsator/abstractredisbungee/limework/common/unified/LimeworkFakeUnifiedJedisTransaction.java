package de.simonsator.abstractredisbungee.limework.common.unified;

import com.imaginarycode.minecraft.redisbungee.internal.jedis.AbstractTransaction;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisTransaction;

public class LimeworkFakeUnifiedJedisTransaction extends FakeJedisTransaction {
	private final AbstractTransaction SOURCE;

	public LimeworkFakeUnifiedJedisTransaction(AbstractTransaction pTransaction) {
		SOURCE = pTransaction;
	}

	@Override
	public void setex(String key, int seconds, String value) {
		SOURCE.setex(key, seconds, value);
	}

	@Override
	public void del(String key) {
		SOURCE.del(key);
	}

	@Override
	public void set(String key, String value) {
		SOURCE.set(key, value);
	}

	@Override
	public void exec() {
		SOURCE.exec();
	}
}
