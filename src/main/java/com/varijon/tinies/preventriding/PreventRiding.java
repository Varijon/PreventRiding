package com.varijon.tinies.preventriding;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.varijon.tinies.mixin.RideCooldownAccessor;

public class PreventRiding implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("preventriding");

	@Override
	public void onInitialize() {
		EntityMountCallback.EVENT.register((entity) -> {	
			if(!(entity instanceof PlayerEntity))
		    {  
				((RideCooldownAccessor)(Object) entity).setRideCooldown(120);
		    	return ActionResult.FAIL;
		    }
		    return ActionResult.PASS;
		});
	}
}