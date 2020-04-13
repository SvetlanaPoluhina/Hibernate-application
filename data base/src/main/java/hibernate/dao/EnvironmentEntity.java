package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "environment", schema = "db", catalog = "")
public class EnvironmentEntity {
    private int idEnvironment;
    private String browser;
    private Collection<ResultsEntity> resultsByIdEnvironment;

    @Id
    @Column(name = "id_environment", nullable = false)
    public int getIdEnvironment() {
        return idEnvironment;
    }

    public void setIdEnvironment(int idEnvironment) {
        this.idEnvironment = idEnvironment;
    }

    @Basic
    @Column(name = "browser", nullable = false, length = 45)
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnvironmentEntity that = (EnvironmentEntity) o;

        if (idEnvironment != that.idEnvironment) return false;
        if (browser != null ? !browser.equals(that.browser) : that.browser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEnvironment;
        result = 31 * result + (browser != null ? browser.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "environmentByIdEnvironment")
    public Collection<ResultsEntity> getResultsByIdEnvironment() {
        return resultsByIdEnvironment;
    }

    public void setResultsByIdEnvironment(Collection<ResultsEntity> resultsByIdEnvironment) {
        this.resultsByIdEnvironment = resultsByIdEnvironment;
    }
}
