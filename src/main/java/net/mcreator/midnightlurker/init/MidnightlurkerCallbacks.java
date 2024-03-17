package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.mcreator.midnightlurker.procedures.*;


public class MidnightlurkerCallbacks {
    public static void init() {
        AttackEntityCallback.EVENT.register(new DestroytexEntityIsHurtProcedure());
        AttackEntityCallback.EVENT.register(new Destroytex2EntityIsHurtProcedure());
        AttackEntityCallback.EVENT.register(new Destroytex3EntityIsHurtProcedure());
        AttackEntityCallback.EVENT.register(new Destroytex4EntityIsHurtProcedure());

        UseItemCallback.EVENT.register(new InsanityFoodReduceProcedure());
    }
}
