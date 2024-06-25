package net.danygames2014.photomode;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import org.lwjgl.input.Keyboard;


@SuppressWarnings({"unused", "deprecation"})
public class KeyPressedListener {

    Minecraft minecraft = null;
    public static boolean releasedMouse = false;

    @EventListener
    public void keyPress(KeyStateChangedEvent event) {
        if (minecraft == null) {
            minecraft = ((Minecraft) FabricLoader.getInstance().getGameInstance());
        }

        if (Keyboard.getEventKeyState() && minecraft.currentScreen == null) {
            // Photo Mode
            if (Keyboard.isKeyDown(KeyBindingListener.photoMode.code)) {
                this.minecraft.setScreen(new PhotoModeScreen(null));
            }
        }
    }
}
