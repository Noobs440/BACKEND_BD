package com.project_service.models;

import java.io.Serializable;
import java.util.Objects;

public class DocVerId implements Serializable {

    private Long docId;
    private Long verId;

    // Constructeurs
    public DocVerId() {}

    public DocVerId(Long docId, Long verId) {
        this.docId = docId;
        this.verId = verId;
    }

    // Getters et setters
    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getVerId() {
        return verId;
    }

    public void setVerId(Long verId) {
        this.verId = verId;
    }

    // hashCode et equals indispensables pour une clé composite
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocVerId)) return false;
        DocVerId that = (DocVerId) o;
        return Objects.equals(docId, that.docId) && Objects.equals(verId, that.verId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId, verId);
    }
}
