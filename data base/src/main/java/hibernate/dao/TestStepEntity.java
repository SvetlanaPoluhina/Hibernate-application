package hibernate.dao;

import javax.persistence.*;

@Entity
@Table(name = "test_step", schema = "db", catalog = "")
public class TestStepEntity {
    private int idTestStep;
    private String nameStep;
    private TestEntity testByTestid;

    @Id
    @Column(name = "id_test_step", nullable = false)
    public int getIdTestStep() {
        return idTestStep;
    }

    public void setIdTestStep(int idTestStep) {
        this.idTestStep = idTestStep;
    }

    @Basic
    @Column(name = "name_step", nullable = false, length = 45)
    public String getNameStep() {
        return nameStep;
    }

    public void setNameStep(String nameStep) {
        this.nameStep = nameStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestStepEntity that = (TestStepEntity) o;

        if (idTestStep != that.idTestStep) return false;
        if (nameStep != null ? !nameStep.equals(that.nameStep) : that.nameStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTestStep;
        result = 31 * result + (nameStep != null ? nameStep.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "testid", referencedColumnName = "id_test", nullable = false)
    public TestEntity getTestByTestid() {
        return testByTestid;
    }

    public void setTestByTestid(TestEntity testByTestid) {
        this.testByTestid = testByTestid;
    }
}
