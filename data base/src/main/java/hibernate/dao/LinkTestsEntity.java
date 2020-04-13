package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "link_tests", schema = "db", catalog = "")
public class LinkTestsEntity {
    private int idLinkTests;
    private TestEntity testByIdTest;
    private TestSuiteEntity testSuiteByIdTestSuite;
    private Collection<ResultsEntity> resultsByIdLinkTests;

    @Id
    @Column(name = "id_link_tests", nullable = false)
    public int getIdLinkTests() {
        return idLinkTests;
    }

    public void setIdLinkTests(int idLinkTests) {
        this.idLinkTests = idLinkTests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkTestsEntity that = (LinkTestsEntity) o;

        if (idLinkTests != that.idLinkTests) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idLinkTests;
    }

    @ManyToOne
    @JoinColumn(name = "id_test", referencedColumnName = "id_test", nullable = false)
    public TestEntity getTestByIdTest() {
        return testByIdTest;
    }

    public void setTestByIdTest(TestEntity testByIdTest) {
        this.testByIdTest = testByIdTest;
    }

    @ManyToOne
    @JoinColumn(name = "id_test_suite", referencedColumnName = "id_test_suite", nullable = false)
    public TestSuiteEntity getTestSuiteByIdTestSuite() {
        return testSuiteByIdTestSuite;
    }

    public void setTestSuiteByIdTestSuite(TestSuiteEntity testSuiteByIdTestSuite) {
        this.testSuiteByIdTestSuite = testSuiteByIdTestSuite;
    }

    @OneToMany(mappedBy = "linkTestsByIdLinkTests")
    public Collection<ResultsEntity> getResultsByIdLinkTests() {
        return resultsByIdLinkTests;
    }

    public void setResultsByIdLinkTests(Collection<ResultsEntity> resultsByIdLinkTests) {
        this.resultsByIdLinkTests = resultsByIdLinkTests;
    }
}
