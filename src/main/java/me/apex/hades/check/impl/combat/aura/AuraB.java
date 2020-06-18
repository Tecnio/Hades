package me.apex.hades.check.impl.combat.aura;

import io.github.retrooper.packetevents.event.PacketEvent;
import me.apex.hades.check.Check;
import me.apex.hades.check.CheckInfo;
import me.apex.hades.event.impl.packetevents.AttackEvent;
import me.apex.hades.event.impl.packetevents.FlyingEvent;
import me.apex.hades.user.User;

@CheckInfo(name = "Aura", type = "B")
public class AuraB extends Check {

    private int ticks;

    @Override
    public void onEvent(PacketEvent e, User user) {
        if (e instanceof AttackEvent) {
            if (ticks < 1) {
                flag(user, "multiple attacks in tick, t: " + ticks);
            }

            this.ticks = 0;
        } else if (e instanceof FlyingEvent) {
            ticks++;
        }
    }

}
