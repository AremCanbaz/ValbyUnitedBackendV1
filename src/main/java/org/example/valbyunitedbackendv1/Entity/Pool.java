package org.example.valbyunitedbackendv1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pool {
    @Id
    private Long poolId;
    private String poolName;
    private String rowName;
    private boolean showResult;
    private boolean showProgram;

    // Getters and Setters
    public Long getPoolId() { return poolId; }
    public void setPoolId(Long poolId) { this.poolId = poolId; }
    public String getPoolName() { return poolName; }
    public void setPoolName(String poolName) { this.poolName = poolName; }
    public String getRowName() { return rowName; }
    public void setRowName(String rowName) { this.rowName = rowName; }
    public boolean isShowResult() { return showResult; }
    public void setShowResult(boolean showResult) { this.showResult = showResult; }
    public boolean isShowProgram() { return showProgram; }
    public void setShowProgram(boolean showProgram) { this.showProgram = showProgram; }

    @Override
    public String toString() {
        return "Pool{" +
                "poolId=" + poolId +
                ", poolName='" + poolName + '\'' +
                ", rowName='" + rowName + '\'' +
                ", showResult=" + showResult +
                ", showProgram=" + showProgram +
                '}';
    }
}
