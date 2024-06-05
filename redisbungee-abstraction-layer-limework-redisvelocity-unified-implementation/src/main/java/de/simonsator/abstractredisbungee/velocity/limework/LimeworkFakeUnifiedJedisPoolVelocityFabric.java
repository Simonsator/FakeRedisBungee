package de.simonsator.abstractredisbungee.velocity.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import de.simonsator.abstractredisbungee.limework.common.unified.LimeworkFakeUnifiedJedisPool;

public class LimeworkFakeUnifiedJedisPoolVelocityFabric {
	public static LimeworkFakeUnifiedJedisPool create() {
		return new LimeworkFakeUnifiedJedisPool(RedisBungeeAPI.getRedisBungeeApi().getSummoner().obtainResource());
	}
}
