package com.varijon.tinies.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.entity.Entity;

@Mixin(Entity.class)
public interface RideCooldownAccessor 
{
    @Accessor("ridingCooldown")
    public void setRideCooldown(int rideCooldown);
}