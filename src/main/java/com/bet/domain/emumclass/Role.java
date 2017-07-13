package com.bet.domain.emumclass;

/**
 * Created by pengweiyuan on 12/06/2017.
 */
public enum Role {
    
    NORMAL(0, "普通"), ADMIN(1, "管理员");


    private int type;

    private String desc;

    Role(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
