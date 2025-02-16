package org.example.valbyunitedbackendv1.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("PoolId")
    private Long poolId;

    @JsonProperty("PoolName")
    private String poolName;

    @JsonProperty("RowName")
    private String rowName;

    @JsonProperty("ShowResult")
    private boolean showResult;

    @JsonProperty("ShowProgram")
    private boolean showProgram;

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPoolName() {
        return poolName;
    }
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }
    public String getRowName() {
        return rowName;
    }
    public void setRowName(String rowName) {
        this.rowName = rowName;
    }
    public boolean isShowResult() {
        return showResult;
    }
    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }
    public boolean isShowProgram() {
        return showProgram;
    }
    public void setShowProgram(boolean showProgram) {
        this.showProgram = showProgram;
    }
}
