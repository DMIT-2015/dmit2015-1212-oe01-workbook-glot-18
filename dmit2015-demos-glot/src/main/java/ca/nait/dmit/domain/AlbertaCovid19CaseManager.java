package ca.nait.dmit.domain;

import lombok.Getter;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlbertaCovid19CaseManager {
    @Getter
    private List<AlbertaCovid19Case> albertaCovid19CaseList = new ArrayList<>();

    public AlbertaCovid19CaseManager() throws IOException {
        try(var reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/data/covid-19-alberta-statistics-data.csv")))){

            String lineText;
            final var DELIMITER = ",(?=(?:[^\"]*\"[^\"]*\")*[*\"]*$)";;
            reader.readLine();
            var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while ((lineText = reader.readLine()) != null){
                AlbertaCovid19Case currentCase = new AlbertaCovid19Case();
                String[] values = lineText.split(DELIMITER, -1);

                currentCase.setId(Integer.parseInt(values[0].replaceAll("\"", "")));
                currentCase.setDateReported(LocalDate.parse(values[1].replaceAll("\"", ""), dateTimeFormatter));
                currentCase.setAhsZone(values[2].replaceAll("\"", ""));
                currentCase.setGender(values[3].replaceAll("\"", ""));
                currentCase.setAgeGroup(values[4].replaceAll("\"", ""));
                currentCase.setCaseStatus(values[5].replaceAll("\"", ""));
                currentCase.setCaseType(values[6].replaceAll("\"", ""));

                albertaCovid19CaseList.add(currentCase);
            }

        }
    }
}
