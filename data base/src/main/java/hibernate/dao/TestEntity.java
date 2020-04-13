package hibernate.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "test", schema = "db", catalog = "")
public class TestEntity {
    private int idTest;
    private String nameTest;
    private String description;
    private Collection<LinkTestsEntity> linkTestsByIdTest;
    private Collection<TestStepEntity> testStepsByIdTest;

    @Id
    @Column(name = "id_test", nullable = false)
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Basic
    @Column(name = "name_test", nullable = false, length = 45)
    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntity that = (TestEntity) o;

        if (idTest != that.idTest) return false;
        if (nameTest != null ? !nameTest.equals(that.nameTest) : that.nameTest != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTest;
        result = 31 * result + (nameTest != null ? nameTest.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "testByIdTest")
    public Collection<LinkTestsEntity> getLinkTestsByIdTest() {
        return linkTestsByIdTest;
    }

    public void setLinkTestsByIdTest(Collection<LinkTestsEntity> linkTestsByIdTest) {
        this.linkTestsByIdTest = linkTestsByIdTest;
    }

    @OneToMany(mappedBy = "testByTestid")
    public Collection<TestStepEntity> getTestStepsByIdTest() {
        return testStepsByIdTest;
    }

    public void setTestStepsByIdTest(Collection<TestStepEntity> testStepsByIdTest) {
        this.testStepsByIdTest = testStepsByIdTest;
    }
}
