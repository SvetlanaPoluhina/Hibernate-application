package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "version", schema = "db", catalog = "")
public class VersionEntity {
    private int idVersion;
    private Collection<ResultsEntity> resultsByIdVersion;
    private SystemUnderTestEntity systemUnderTestByIdSystem;

    @Id
    @Column(name = "id_version", nullable = false)
    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VersionEntity that = (VersionEntity) o;

        if (idVersion != that.idVersion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idVersion;
    }

    @OneToMany(mappedBy = "versionByVer")
    public Collection<ResultsEntity> getResultsByIdVersion() {
        return resultsByIdVersion;
    }

    public void setResultsByIdVersion(Collection<ResultsEntity> resultsByIdVersion) {
        this.resultsByIdVersion = resultsByIdVersion;
    }

    @ManyToOne
    @JoinColumn(name = "id_system", referencedColumnName = "id_system_under_test", nullable = false)
    public SystemUnderTestEntity getSystemUnderTestByIdSystem() {
        return systemUnderTestByIdSystem;
    }

    public void setSystemUnderTestByIdSystem(SystemUnderTestEntity systemUnderTestByIdSystem) {
        this.systemUnderTestByIdSystem = systemUnderTestByIdSystem;
    }
}
