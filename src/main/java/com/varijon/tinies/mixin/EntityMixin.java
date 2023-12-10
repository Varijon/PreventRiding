package com.varijon.tinies.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.varijon.tinies.preventriding.EntityMountCallback;

import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;

@Mixin(Entity.class)
public class EntityMixin 
{
// 	@Inject(method = "startRiding", at = @At("HEAD"), cancellable = true)
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;hasVehicle()Z"), method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", cancellable = true)
    public void onRide(CallbackInfoReturnable<Boolean> ci) {
        ActionResult result = EntityMountCallback.EVENT.invoker().doRiding((Entity) (Object) this);
 
        if(result == ActionResult.FAIL) 
        {
        	ci.cancel();
        }
    }
}

