package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tester", schema = "db", catalog = "")
public class TesterEntity {
    private int idTester;
    private String nameTester;
    private Collection<ResultsEntity> resultsByIdTester;

    @Id
    @Column(name = "id_tester", nullable = false)
    public int getIdTester() {
        return idTester;
    }

    public void setIdTester(int idTester) {
        this.idTester = idTester;
    }

    @Basic
    @Column(name = "name_tester", nullable = false, length = 45)
    public String getNameTester() {
        return nameTester;
    }

    public void setNameTester(String nameTester) {
        this.nameTester = nameTester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TesterEntity that = (TesterEntity) o;

        if (idTester != that.idTester) return false;
        if (nameTester != null ? !nameTester.equals(that.nameTester) : that.nameTester != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTester;
        result = 31 * result + (nameTester != null ? nameTester.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "testerByIdTester")
    public Collection<ResultsEntity> getResultsByIdTester() {
        return resultsByIdTester;
    }

    public void setResultsByIdTester(Collection<ResultsEntity> resultsByIdTester) {
        this.resultsByIdTester = resultsByIdTester;
    }
}
