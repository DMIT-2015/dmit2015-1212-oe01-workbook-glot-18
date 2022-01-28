package ca.nait.dmit.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlbertaCovid19CaseManagerTest {

    private static AlbertaCovid19CaseManager caseManager;
    @BeforeAll
    static void beforeAll() throws IOException{
        caseManager = new AlbertaCovid19CaseManager();
    }

    @Test
    void getAlbertaCovid19CaseList() {
        assertEquals(487436, caseManager.getAlbertaCovid19CaseList().size());
    }
}