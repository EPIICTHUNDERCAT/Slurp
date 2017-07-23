package com.github.slurp.network;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import toughasnails.api.TANPotions;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.thirst.ThirstHandler;

import javax.annotation.Nullable;

import com.github.slurp.Globals;

/**
 * @author CJm721 Code for Overloaded Multitool
 *         None of this code belongs to me!
 *         https://minecraft.curseforge.com/projects/overloaded?gameCategorySlug=mc-mods&projectID=264601
 */
public class MessageHandler implements IMessageHandler<RightClickMessage, IMessage> {

    /**
     * Called when a message is received of the appropriate type. You can
     * optionally return a reply message, or null if no reply is needed.
     *
     * @param message The message
     * @param ctx     the context of the message
     * @return an optional return message
     */
    @Override
    @Nullable
    public IMessage onMessage(RightClickMessage message, MessageContext ctx) {
        BlockPos blockpos = message.getPos();
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;
        IBlockState iblockstate = player.getServerWorld().getBlockState(blockpos);
        Material material = iblockstate.getMaterial();
        ThirstHandler thirstHandler = (ThirstHandler) ThirstHelper.getThirstData(player);

        if (thirstHandler.isThirsty()) {

            if (material == Material.WATER && (iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

                thirstHandler.addStats(Globals.DRINK_AMOUNT, Globals.DRINK_HYDRATIONS);
                player.addPotionEffect(new PotionEffect(TANPotions.thirst, Globals.THIRST_EFFECT_DURATION, Globals.THIRST_EFFECT_POTENCY));
                player.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 10, 1);
            }
        }
        return null;
    }
}