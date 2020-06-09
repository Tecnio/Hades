package me.apex.hades.check.impl.other.vape;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import me.apex.hades.Hades;
import me.apex.hades.check.api.Check;
import me.apex.hades.check.api.CheckInfo;
import me.apex.hades.objects.User;
import me.apex.hades.objects.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;

@CheckInfo(name = "Vape", type = "A")
public class VapeA extends Check implements Listener, PluginMessageListener {

    public VapeA(){
        Bukkit.getServer().getPluginManager().registerEvents(this, Hades.getInstance());
    }

    @Override
    public void onPacket(PacketReceiveEvent e, User user) { }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("\u00a78 \u00a78 \u00a71 \u00a73 \u00a73 \u00a77 \u00a78 ");
    }

    public void onPluginMessageReceived(String string, Player player, byte[] bytes) {
        try {
            String string2 = new String(bytes);
        }
        catch (Exception exception) {
            String string3 = "";
        }
        flag(UserManager.INSTANCE.getUser(player.getUniqueId()), "player has joined the server with vape client.!");
    }
}
