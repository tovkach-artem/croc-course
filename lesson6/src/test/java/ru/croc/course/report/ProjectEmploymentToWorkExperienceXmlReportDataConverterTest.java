package ru.croc.course.report;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.croc.course.support.xml.JacksonXmlDataConverter;
import ru.croc.course.support.xml.XmlDataConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class ProjectEmploymentToWorkExperienceXmlReportDataConverterTest {

    private ProjectEmploymentToWorkExperienceXmlReportDataConverter projectEmploymentToWorkExperienceXmlReportDataConverter;
    private XmlDataConverter xmlDataConverter;

    @BeforeEach
    public void prepare() {
        this.xmlDataConverter = new JacksonXmlDataConverter();
        this.projectEmploymentToWorkExperienceXmlReportDataConverter =
                new ProjectEmploymentToWorkExperienceXmlReportDataConverter(xmlDataConverter);
    }

    @Test
    public void shouldConvertProjectEmploymentToWorkExperienceReport() throws IOException {
        String input = Files.readString(Path.of( "src", "test", "resources", "test-project-employment.xml"));
        String actual = projectEmploymentToWorkExperienceXmlReportDataConverter.convert(input);
        String expected = Files.readString(Path.of( "src", "test", "resources", "test-expected-work-experience-report.xml"));
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}