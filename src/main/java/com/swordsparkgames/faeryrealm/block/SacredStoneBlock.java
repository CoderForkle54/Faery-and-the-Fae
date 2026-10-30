package net.swordsparkgames.faeryrealm.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SacredStoneBlock extends Block {
	public SacredStoneBlock() {
		super(BlockBehaviour.Properties.of().strength(1.6f, 11.5f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}