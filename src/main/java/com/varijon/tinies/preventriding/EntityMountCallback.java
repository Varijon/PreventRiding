package com.varijon.tinies.preventriding;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;

public interface EntityMountCallback 
{
    Event<EntityMountCallback> EVENT = EventFactory.createArrayBacked(EntityMountCallback.class,
            (listeners) -> (entity) -> {
                for (EntityMountCallback listener : listeners) {
                    ActionResult result = listener.doRiding(entity);
     
                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }
     
            return ActionResult.PASS;
        });
     
        ActionResult doRiding(Entity entity);
}
