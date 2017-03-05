package ru.efremenkov.business.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
@XmlRootElement
public class CacheConfigurationRq {
    private long heapSize;
    private long offheapSize;
    private long diskMemSize;
    private long duration;

    public long getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(long heapSize) {
        this.heapSize = heapSize;
    }

    public long getOffheapSize() {
        return offheapSize;
    }

    public void setOffheapSize(long offheapSize) {
        this.offheapSize = offheapSize;
    }

    public long getDiskMemSize() {
        return diskMemSize;
    }

    public void setDiskMemSize(long diskMemSize) {
        this.diskMemSize = diskMemSize;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
