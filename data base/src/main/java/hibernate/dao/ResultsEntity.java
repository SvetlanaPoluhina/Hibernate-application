package hibernate.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "results", schema = "db", catalog = "")
public class ResultsEntity {
    private int idResults;
    private Date date;
    private TesterEntity testerByIdTester;
    private LinkTestsEntity linkTestsByIdLinkTests;
    private EnvironmentEntity environmentByIdEnvironment;
    private VersionEntity versionByVer;
    private StatusEntity statusByIdStatus;

    @Id
    @Column(name = "id_results", nullable = false)
    public int getIdResults() {
        return idResults;
    }

    public void setIdResults(int idResults) {
        this.idResults = idResults;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultsEntity that = (ResultsEntity) o;

        if (idResults != that.idResults) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idResults;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_tester", referencedColumnName = "id_tester", nullable = false)
    public TesterEntity getTesterByIdTester() {
        return testerByIdTester;
    }

    public void setTesterByIdTester(TesterEntity testerByIdTester) {
        this.testerByIdTester = testerByIdTester;
    }

    @ManyToOne
    @JoinColumn(name = "id_link_tests", referencedColumnName = "id_link_tests", nullable = false)
    public LinkTestsEntity getLinkTestsByIdLinkTests() {
        return linkTestsByIdLinkTests;
    }

    public void setLinkTestsByIdLinkTests(LinkTestsEntity linkTestsByIdLinkTests) {
        this.linkTestsByIdLinkTests = linkTestsByIdLinkTests;
    }

    @ManyToOne
    @JoinColumn(name = "id_environment", referencedColumnName = "id_environment", nullable = false)
    public EnvironmentEntity getEnvironmentByIdEnvironment() {
        return environmentByIdEnvironment;
    }

    public void setEnvironmentByIdEnvironment(EnvironmentEntity environmentByIdEnvironment) {
        this.environmentByIdEnvironment = environmentByIdEnvironment;
    }

    @ManyToOne
    @JoinColumn(name = "№ver", referencedColumnName = "id_version", nullable = false)
    public VersionEntity getVersionByVer() {
        return versionByVer;
    }

    public void setVersionByVer(VersionEntity versionByVer) {
        this.versionByVer = versionByVer;
    }

    @ManyToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id_status", nullable = false)
    public StatusEntity getStatusByIdStatus() {
        return statusByIdStatus;
    }

    public void setStatusByIdStatus(StatusEntity statusByIdStatus) {
        this.statusByIdStatus = statusByIdStatus;
    }
}
