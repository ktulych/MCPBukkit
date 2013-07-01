package org.bukkit.craftbukkit.command;

import java.lang.reflect.Method;


import org.bukkit.command.CommandSender;

public class ServerCommandListener implements net.minecraft.command.ICommandSender {
    private final CommandSender commandSender;
    private final String prefix;

    public ServerCommandListener(CommandSender commandSender) {
        this.commandSender = commandSender;
        String[] parts = commandSender.getClass().getName().split("\\.");
        this.prefix = parts[parts.length - 1];
    }

    public void func_70006_a(net.minecraft.util.ChatMessageComponent chatmessage) {
        this.commandSender.sendMessage(chatmessage.toString());
    }

    public CommandSender getSender() {
        return commandSender;
    }

    public String func_70005_c_() {
        try {
            Method getName = commandSender.getClass().getMethod("getName");

            return (String) getName.invoke(commandSender);
        } catch (Exception e) {}

        return this.prefix;
    }

    public boolean func_70003_b(int i, String s) {
        return true;
    }

    public net.minecraft.util.ChunkCoordinates func_82114_b() {
        return new net.minecraft.util.ChunkCoordinates(0, 0, 0);
    }

    public net.minecraft.world.World func_130014_f_() {
        return null;
    }
}
