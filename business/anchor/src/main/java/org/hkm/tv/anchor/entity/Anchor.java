package org.hkm.tv.anchor.entity;

import lombok.Data;
import org.hkm.base.BaseEntity;

import java.util.Map;

@Data
public class Anchor extends BaseEntity {

    private Long id;
    private String name;
    private String key;//串流秘钥
    private Long level;
    private Integer roomId;
    private State state;

    @Override
    public void entity(Map<String, Object> map) {
        super.entity(map);
        state = State.valueOf(map.get("state").toString());
    }

    public enum State{
        OFF(0),
        ON(1),
        ILLEGAL(-1)
        ;

        private int v;

        State(int v) {
            this.v = v;
        }

        public int value(){
            return this.v;
        }

        public static State state(int v) {
            State[] states = State.values();
            for (State state : states) {
                if (state.v == v) {
                    return state;
                }
            }
            throw new RuntimeException(("不认识的枚举值"));
        }
    }

}
