package com.github.slurp.proxy;

import com.github.slurp.EventManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

public void preInit(FMLPreInitializationEvent preEvent) {
		register(preEvent);

	}
public void init(FMLInitializationEvent event) {
		registerRenders(event);

	}
private void register(FMLPreInitializationEvent preEvent) {

if (Loader.isModLoaded("ToughAsNails")) {
MinecraftForge.EVENT_BUS.register(new EventManager());
		}
}
public void registerRenders(FMLInitializationEvent event) {
	}
public void registerRender(FMLInitializationEvent event) {
	}
public void registerEntities(FMLPreInitializationEvent preEvent) {
	}
}
