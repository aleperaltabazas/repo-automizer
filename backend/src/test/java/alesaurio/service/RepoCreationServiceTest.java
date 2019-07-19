package alesaurio.service;

import alesaurio.transfer.inner.RepoDTO;
import alesaurio.config.TestConfig;
import alesaurio.service.naming.NumberedNaming;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = {TestConfig.class})
public class RepoCreationServiceTest {
    @Autowired
    private RepoCreationService mockedService;

    @Test
    public void create_repo() {
        RepoDTO actual = mockedService.createRepo("some-test-repo", Optional.empty(), Arrays.asList("foo", "bar"));
        RepoDTO expected = new RepoDTO("some-test-repo", "https://someurl.com/repositories/some-test-repo");

        assertEquals(expected, actual);
    }

    @Test
    public void create_two_repos_by_number() {
        List<RepoDTO> actual = mockedService.createRepos("some-test-repo", Optional.empty(),
                Arrays.asList(Arrays.asList("foo", "bar"), Arrays.asList("biz, baz")), new NumberedNaming());
        List<RepoDTO> expected = Arrays.asList(
                new RepoDTO("some-test-repo-1", "https://someurl.com/repositories/some-test-repo-1"),
                new RepoDTO("some-test-repo-2", "https://someurl.com/repositories/some-test-repo-2")
        );

        assertEquals(expected, actual);
    }
}