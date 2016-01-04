package com.xiaomo.timeMachine.core.entity.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {

    @Version
    protected long version;

    public abstract long getId();

    public long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
