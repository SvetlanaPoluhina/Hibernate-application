package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "status", schema = "db", catalog = "")
public class StatusEntity {
    private int idStatus;
    private String status;
    private Collection<ResultsEntity> resultsByIdStatus;

    @Id
    @Column(name = "id_status", nullable = false)
    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusEntity that = (StatusEntity) o;

        if (idStatus != that.idStatus) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStatus;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusByIdStatus")
    public Collection<ResultsEntity> getResultsByIdStatus() {
        return resultsByIdStatus;
    }

    public void setResultsByIdStatus(Collection<ResultsEntity> resultsByIdStatus) {
        this.resultsByIdStatus = resultsByIdStatus;
    }
}
