package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "test_suite", schema = "db", catalog = "")
public class TestSuiteEntity {
    private int idTestSuite;
    private String nameTestSuite;
    private Collection<LinkTestsEntity> linkTestsByIdTestSuite;

    @Id
    @Column(name = "id_test_suite", nullable = false)
    public int getIdTestSuite() {
        return idTestSuite;
    }

    public void setIdTestSuite(int idTestSuite) {
        this.idTestSuite = idTestSuite;
    }

    @Basic
    @Column(name = "name_test_suite", nullable = true, length = 45)
    public String getNameTestSuite() {
        return nameTestSuite;
    }

    public void setNameTestSuite(String nameTestSuite) {
        this.nameTestSuite = nameTestSuite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestSuiteEntity that = (TestSuiteEntity) o;

        if (idTestSuite != that.idTestSuite) return false;
        if (nameTestSuite != null ? !nameTestSuite.equals(that.nameTestSuite) : that.nameTestSuite != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTestSuite;
        result = 31 * result + (nameTestSuite != null ? nameTestSuite.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "testSuiteByIdTestSuite")
    public Collection<LinkTestsEntity> getLinkTestsByIdTestSuite() {
        return linkTestsByIdTestSuite;
    }

    public void setLinkTestsByIdTestSuite(Collection<LinkTestsEntity> linkTestsByIdTestSuite) {
        this.linkTestsByIdTestSuite = linkTestsByIdTestSuite;
    }
}
