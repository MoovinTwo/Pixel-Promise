package com.moovintwo.pixel_promise.item.tools.Chisel;

import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Chisel_Item extends Item {

    public Chisel_Item(Settings settings) { super(settings); }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);

        if (user.getOffHandStack().isOf(Pixel_Items.UNPOLISHED_BLOODSTONE)) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(stack);
        }

        return TypedActionResult.pass(stack);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {

        if (!(user instanceof PlayerEntity player)) return;

        ItemStack offhand = player.getOffHandStack();

        if (!offhand.isOf(Pixel_Items.UNPOLISHED_BLOODSTONE)) return;

        if (!world.isClient && remainingUseTicks % 6 == 0) {

            float pitch = 0.9f + world.random.nextFloat() * 0.3f;

            playSound(world, player, SoundEvents.BLOCK_STONE_HIT, SoundCategory.PLAYERS, 0.7f, pitch);

        }

        if (world.isClient && remainingUseTicks % 3 == 0) {

            renderItemParticles(offhand.getItem(), player, world);

        }

        if (remainingUseTicks == 1 && !world.isClient) {

            offhand.decrement(1);

            ItemStack polished = new ItemStack(Pixel_Items.POLISHED_BLOODSTONE);

            if (!player.getInventory().insertStack(polished)) { player.dropItem(polished, false); }

            stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));

            playSound(world, player, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.PLAYERS, 1f, 1f);

        }
    }

    private void playSound(World world, LivingEntity player, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        world.playSound(
                null,
                player.getBlockPos(),
                sound,
                category,
                volume,
                pitch
        );
    }

    private void renderItemParticles(Item item, PlayerEntity player, World world) {
        for (int i = 0; i < 1; i++) {
            world.addParticle(
                    new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(item)),
                    player.getX() + player.getRotationVector().x * 0.6,
                    player.getY() + 1.2,
                    player.getZ() + player.getRotationVector().z * 0.6,
                    (world.random.nextDouble() - 0.5) * 0.15,
                    world.random.nextDouble() * 0.15,
                    (world.random.nextDouble() - 0.5) * 0.15
            );
        }
    }

}
