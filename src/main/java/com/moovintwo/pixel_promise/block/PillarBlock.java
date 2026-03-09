package com.moovintwo.pixel_promise.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PillarBlock extends Block {

    public static final BooleanProperty ABOVE = BooleanProperty.of("above");
    public static final BooleanProperty BELOW = BooleanProperty.of("below");

    public PillarBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(ABOVE, false)
                .with(BELOW, false));
    }

    private static final VoxelShape BOTTOM = Block.createCuboidShape(0, 0, 0, 16, 2, 16 );

    private static final VoxelShape CENTER = Block.createCuboidShape(1, 2, 1, 15, 14, 15 );
    private static final VoxelShape TALL_CENTER = Block.createCuboidShape(1, 0, 1, 15, 16, 15 );
    private static final VoxelShape TOP_CENTER = Block.createCuboidShape(1, 0, 1, 15, 14, 15 );
    private static final VoxelShape BOTTOM_CENTER = Block.createCuboidShape(1, 2, 1, 15, 16, 15 );

    private static final VoxelShape TOP = Block.createCuboidShape(0, 14, 0, 16, 16, 16 );

    private static final VoxelShape SINGLE = VoxelShapes.union(CENTER, TOP, BOTTOM);
    private static final VoxelShape TOP_CONNECTED = VoxelShapes.union(BOTTOM_CENTER, BOTTOM);
    private static final VoxelShape BOTTOM_CONNECTED = VoxelShapes.union(TOP_CENTER, TOP);
    private static final VoxelShape BOTH_CONNECTED = TALL_CENTER;

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        boolean above = state.get(ABOVE);
        boolean below = state.get(BELOW);

        if (above && below) return BOTH_CONNECTED;
        if (above) return TOP_CONNECTED;
        if (below) return BOTTOM_CONNECTED;

        return SINGLE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(state, world, pos, context);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ABOVE, BELOW);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction,
                                                BlockState neighborState, WorldAccess world,
                                                BlockPos pos, BlockPos neighborPos) {
        boolean above = world.getBlockState(pos.up()).getBlock() instanceof PillarBlock;
        boolean below = world.getBlockState(pos.down()).getBlock() instanceof PillarBlock;
        return state.with(ABOVE, above).with(BELOW, below);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        boolean above = world.getBlockState(pos.up()).getBlock() instanceof PillarBlock;
        boolean below = world.getBlockState(pos.down()).getBlock() instanceof PillarBlock;
        return this.getDefaultState().with(ABOVE, above).with(BELOW, below);
    }

}