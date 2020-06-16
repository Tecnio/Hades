package me.apex.hades.check.impl.player.timer;

import io.github.retrooper.packetevents.event.PacketEvent;
import me.apex.hades.check.Check;
import me.apex.hades.check.CheckInfo;
import me.apex.hades.event.impl.packetevents.FlyingEvent;
import me.apex.hades.user.User;
import me.apex.hades.util.MathUtil;

import java.util.Deque;
import java.util.LinkedList;

@CheckInfo(name = "Timer", type = "B")
public class TimerB extends Check {

    private Deque<Long> flyingDeque = new LinkedList();

    @Override
    public void onEvent(PacketEvent e, User user) {
        if (e instanceof FlyingEvent){
            flyingDeque.add(e.getTimestamp());

            if (flyingDeque.size() == 10) {
                double deviation = MathUtil.getStandardDeviation(flyingDeque.stream().mapToLong(l -> l).toArray());

                if (deviation > 160) {
                    if (vl++ > 1)
                        flag(user, "deviation = " + deviation);
                } else vl = 0;

                flyingDeque.clear();
            }
        }
    }
}
